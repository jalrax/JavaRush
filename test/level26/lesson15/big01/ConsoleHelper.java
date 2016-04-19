package com.javarush.test.level26.lesson15.big01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by repin.s on 18.04.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String s = "";
        try
        {
            s = reader.readLine();
        }
        catch (IOException e)
        {
        }
        return s;
    }


    public static String askCurrencyCode()
    {
        String askCode;

        writeMessage("Input currency code:");

        askCode = readString();

        while (askCode.length() != 3) // Проверка на корректность
        {
            writeMessage("Wrong currency code. Input currency code:");

            askCode = readString();
        }

        return askCode.toUpperCase();
    }


    public static String[]
    getValidTwoDigits(String currencyCode)
    {
        writeMessage("Input your denomination and count money:");
        String massive = "";
        String[] arg = massive.split(" ");
        while (true)
        {
            try
            {
                massive = readString();
                arg = massive.split(" ");
                Integer currency = Integer.valueOf(arg[0]);
                Integer number = Integer.valueOf(arg[1]);

                if (arg.length != 2 || currency < 0 || number < 0)
                {
                    writeMessage("try again");
                    continue;
                } else
                    break;

            }
            catch (Exception o)
            {
                writeMessage("try again");
                continue;
            }
        }
        return arg;
    }

    public static Operation askOperation()
    {
        while (true)
        {
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("invalid.data");
        }

    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }
}
