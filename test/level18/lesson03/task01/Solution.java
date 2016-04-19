package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int max;
        List<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        inputStream.close();

        max = list.get(0);
        for (Integer aList : list)
        {
            if (aList > max)
                max = aList;
        }

        System.out.println(max);
    }
}
