package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by repin.s on 13.05.2016.
 */
public class BotClient extends Client
{
    private static Set<String> botNames = new HashSet<>();

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName()
    {
        String botName = String.format("date_bot_%d", new Random().nextInt(100));
        while (!botNames.contains(botName))
        {
            botNames.add(botName);
        }
        return botName;
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    public class BotSocketThread extends SocketThread
    {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            String userName;
            String userText;
            String dateTimeformat = null;

            ConsoleHelper.writeMessage(message);
            String[] buffer = message.split(": ");
            if (buffer.length == 2)
            {
                userName = buffer[0];
                userText = buffer[1];

                switch (userText)
                {
                    case "дата":
                        dateTimeformat = "d.MM.YYYY";
                        break;
                    case "день":
                        dateTimeformat = "d";
                        break;
                    case "месяц":
                        dateTimeformat = "MMMM";
                        break;
                    case "год":
                        dateTimeformat = "YYYY";
                        break;
                    case "время":
                        dateTimeformat = "H:mm:ss";
                        break;
                    case "час":
                        dateTimeformat = "H";
                        break;
                    case "минуты":
                        dateTimeformat = "m";
                        break;
                    case "секунды":
                        dateTimeformat = "s";
                        break;
                }

                if (dateTimeformat != null)
                {
                    String reply = String.format("Информация для %s: %s", userName,
                            new SimpleDateFormat(dateTimeformat).format(Calendar.getInstance().getTime()));
                    sendTextMessage(reply);
                }
            }
        }
    }
}