package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


/**
 * Created by Alex on 29.04.2014.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");
        String answer = ConsoleHelper.readString();
        if (answer.equalsIgnoreCase("y"))
        {
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}