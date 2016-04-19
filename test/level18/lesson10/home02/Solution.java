package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String filename = args[0];
        InputStream fileInStream = new FileInputStream(filename);
        double spaces = 0;
        int symbols = 0;

        while (fileInStream.available() > 0)
        {
            int data = fileInStream.read();

            if ((char) data == ' ')
            {
                spaces++;
                symbols++;
            } else
                symbols++;
        }
        fileInStream.close();
        double result = spaces / symbols * 100;
        System.out.println(String.format("%.2f", result));
    }
}
