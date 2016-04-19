package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String line = "";
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(a));
        BufferedWriter writer = new BufferedWriter(new FileWriter(b));
        while (reader1.ready())
        {
            line = reader1.readLine().replace(".", "!");
            writer.write(line);
        }
        reader1.close();
        writer.close();
    }
}
