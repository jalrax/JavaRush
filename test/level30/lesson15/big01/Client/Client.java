package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

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

    public class SocketThread extends Thread
    {
    }
}