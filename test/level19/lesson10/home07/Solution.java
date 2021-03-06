package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        File file1 = new File(args[1]);
        String tmp = null;
        String a = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        while ((tmp = reader.readLine()) != null)
        {
            String[] buffer = tmp.split(" ");

            for (int i = 0; i < buffer.length; i++)
            {
                if (buffer[i].length() > 6)
                {
                    a += buffer[i] + ",";
                }
            }
        }
        String b = a.substring(0, a.length() - 1);
        writer.write(b);

        reader.close();
        writer.close();
    }
}
