package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String filename = args[0];
        FileInputStream fileInputStream = new FileInputStream(filename);
        Map<Integer, Integer> characterIntegerMap = new TreeMap<>();
        while (fileInputStream.available() > 0)
        {
            int currentANSI = fileInputStream.read();
            if (characterIntegerMap.containsKey(currentANSI))
            {
                characterIntegerMap.put(currentANSI, characterIntegerMap.get(currentANSI) + 1);
            } else
            {
                characterIntegerMap.put(currentANSI, 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair : characterIntegerMap.entrySet())
        {
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char) key + " " + value);
        }
        fileInputStream.close();
    }
}
