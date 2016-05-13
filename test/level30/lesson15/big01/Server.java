package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by repin.s on 28.04.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (String clientName : connectionMap.keySet())
        {
            try
            {
                connectionMap.get(clientName).send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не могу отправить сообщение пользователю: " + clientName);
            }
        }
    }

    public static void main(String[] args)
    {

        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен на порту: " + port);
            while (true)
            {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread
    {

        private Socket socket;

        public Handler(Socket socket)
        {
            super();
            this.socket = socket;
        }


        public void run()
        {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            String errorMessage = "Произошла ошибка обмена данных с удаленным адресом: " + socketAddress;
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socketAddress);
            String userName = null;
            try (Connection connection = new Connection(socket))
            {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage(errorMessage);
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage(errorMessage);
            }
            finally
            {
                if (userName != null)
                {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
            ConsoleHelper.writeMessage("Закрыто соединение с удаленным адресом: " + socketAddress);
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (!Thread.currentThread().isInterrupted())
            {
                Message message = connection.receive();
                if (message.getType().equals(MessageType.TEXT))
                {
                    String messageText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
                } else
                {
                    ConsoleHelper.writeMessage(String.format("Ошибка! Недопустимый тип сообщения (MessageType.%s) от клиента: %s",
                            message.getType().toString(), userName));
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet())
            {
                if (!connectionEntry.getKey().equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, connectionEntry.getKey()));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            boolean accepted = false;
            String name = null;
            while (!accepted)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null)
                    {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }
    }
}
