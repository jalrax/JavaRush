package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        String serverAdress = ConsoleHelper.readString();
        return serverAdress;
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int portAdress = ConsoleHelper.readInt();
        return portAdress;
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения. Соединение будет закрыто.");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                ConsoleHelper.writeMessage("Ошибка выполнения программы.");
                return;
            }
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected)
        {
            String text = ConsoleHelper.readString();
            if (text.toLowerCase().equals("exit"))
            {
                break;
            }
            if (shouldSentTextFromConsole())
            {
                sendTextMessage(text);
            }
        }
    }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник %s присоединился к чату", userName));
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник %s покинул чат", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            boolean accepted = false;
            while (!accepted)
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case NAME_REQUEST:
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (!Thread.currentThread().isInterrupted())
            {
                Message message = connection.receive();
                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run()
        {
            String ip = getServerAddress();
            int port = getServerPort();
            try
            {
                Socket socket = new Socket(ip, port);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
























