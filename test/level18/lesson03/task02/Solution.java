package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int min;
        List<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        inputStream.close();

        min = list.get(0);
        for (Integer a : list)
        {
            if (a < min)
                min = a;
        }

        System.out.println(min);
    }
}
