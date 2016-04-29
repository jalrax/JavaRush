package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by repin.s on 28.04.2016.
 */
public class Server
{
    public static void main(String[] args)
    {

        ConsoleHelper.writeMessage("Enter server port");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;

        try
        {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

        }
        catch (IOException e)
        {
            System.out.println("socket error");
        }

        while (true)
        {
            try
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static class Handler
    {
        Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }
    }
}
