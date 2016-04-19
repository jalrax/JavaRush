package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution
{
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(filename));
        while (reader1.ready())
        {
            String line = reader1.readLine();
            String[] data = line.split(" ");
            for (int d = 0; d < data.length; d++)
            {
                try
                {
                    for (Map.Entry<Integer, String> k : map.entrySet())
                    {
                        if (k.getKey() == Integer.parseInt(data[d]))
                            data[d] = new String(k.getValue().getBytes(), "utf8");
                    }
                }
                catch (NumberFormatException e)
                {
                }
                line = "";
                for (String v : data)
                {
                    line = line + v + " ";
                }
            }
            line = line.substring(0, line.lastIndexOf(" "));
            System.out.println(line);
        }
        reader1.close();
    }
}