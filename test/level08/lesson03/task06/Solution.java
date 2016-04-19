package com.javarush.test.level08.lesson03.task06;

import java.util.Date;

/* Коллекция HashMap из Object
Есть коллекция HashMap<String, Object>, туда занесли 10 различных пар объектов.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
Sim - 5
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);

        Date currentTime = new Date();
        long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;

        int dayCount = (int) (msTimeDistance / msDay);
        System.out.println("Days from start of year: " + dayCount);
    }
}