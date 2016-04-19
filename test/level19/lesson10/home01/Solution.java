package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        for (Map.Entry<String, Double> element : map.entrySet())
            System.out.println(element.getKey() + " " + element.getValue());
    }
}

