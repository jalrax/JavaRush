package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;


class InfoCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        Collection<CurrencyManipulator> allManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (allManipulators.size() <= 0)
        {
            ConsoleHelper.writeMessage("No money available.");
            return;
        }
        for (CurrencyManipulator currencyManipulator : allManipulators)
        {
            if (currencyManipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            } else
            {
                ConsoleHelper.writeMessage("No money available.");
            }

        }


    }
}