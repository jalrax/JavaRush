package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String line = null;
        try
        {
            line = reader.readLine();
            if ("EXIT".equalsIgnoreCase(line))
                throw new InterruptOperationException();
        }
        catch (IOException e)
        {
        }
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage("Input currency code, please...");
        String result = "";
        result = readString();
        if (result.length() != 3)
        {
            writeMessage("You put wrong currency code. Try Again...");
            result = askCurrencyCode();
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Input denomination and amount, please...");
        String[] result;
        try
        {
            result = readString().trim().split(" ");
            if (result.length != 2 || Integer.parseInt(result[0]) <= 0 || Integer.parseInt(result[1]) < 0)
            {
                writeMessage("You put wrong denomination and amount. Try Again...");
                result = getValidTwoDigits(currencyCode);
            }
        }
        catch (NumberFormatException e)
        {
            writeMessage("You put wrong denomination and amount. Try Again...");
            result = getValidTwoDigits(currencyCode);
        }

        return result;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage("Input code of Operation: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        int numbOperation = 0;
        Operation result;
        try
        {
            numbOperation = Integer.parseInt(readString());
        }
        catch (NumberFormatException e)
        {
            writeMessage("You input not a code! Try Again.");
            result = askOperation();
        }

        try
        {
            result = Operation.getAllowableOperationByOrdinal(numbOperation);
        }
        catch (IllegalArgumentException e)
        {
            writeMessage("You input wrong code! Try Again.");
            result = askOperation();
        }

        return result;
    }
}