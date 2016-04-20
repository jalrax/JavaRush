package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator
{
    public String currencyCode;
    public Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            count += denominations.get(denomination);
        }
        denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            result += pair.getKey() * pair.getValue();
        }

        return result;
    }

    public boolean hasMoney()
    {
        boolean result = false;

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            if (pair.getValue() != 0)
            {
                result = true;
            }
        }
        return result;
    }
}