package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();

        FileReader reader = new FileReader(a);
        FileWriter writer = new FileWriter(b);

        while (reader.ready())
        {
            count++;
            int data = reader.read();
            if (count % 2 == 0)
                writer.write(data);
        }

        reader.close();
        writer.close();
    }

}
