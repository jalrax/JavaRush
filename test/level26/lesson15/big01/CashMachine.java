package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by repin.s on 18.04.2016.
 */
public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        String code = ConsoleHelper.askCurrencyCode();
        String[] arg = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator currentMon = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currentMon.addAmount(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));
        System.out.println(currentMon.getTotalAmount());
    }

}
