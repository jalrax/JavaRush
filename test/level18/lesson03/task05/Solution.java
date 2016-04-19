package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода
Пример байт входного файла
44 83 44
Пример вывода
44 83
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        List<Integer> list = new ArrayList<>();
        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        for (Integer a : list) //Смотрим на изначальный список
        {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) //Удаляем дубли
        {
            for (int j = i + 1; j < list.size(); )
            {
                if (list.get(i).equals(list.get(j)))
                {
                    list.remove(j);
                } else j++;
            }
        }
        for (Integer a : list) //Смотрим на список после удаления дублей
        {
            System.out.print(a + " ");
        }
        System.out.println();
        Collections.sort(list); //Сортируем список
        for (Integer a : list) //Смотрим на отсортированный список
        {
            System.out.print(a + " ");
        }
        inputStream.close();
        reader.close();
    }
}

