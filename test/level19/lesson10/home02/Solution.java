package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        String name;
        double value = 0;
        Double max = Double.MIN_VALUE;
        Map<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = null;

        while ((tmp = reader.readLine()) != null)
        {
            String[] a = tmp.split(" ");
            name = a[0];
            value = Double.parseDouble(a[1]);
            if (map.containsKey(name))
            {
                double tmpDouble = map.get(name) + value;
                map.put(name, tmpDouble);
            } else
            {
                map.put(name, value);
            }
        }
        reader.close();

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            max = Math.max(max, pair.getValue());
        }

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
            {
                System.out.println(pair.getKey());
            }
        }
    }
}

