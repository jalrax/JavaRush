package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        File file1 = new File(args[1]);
        String tmp = null;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));

        while ((tmp = reader.readLine()) != null)
        {
            String[] buffer = tmp.split(" ");
            for (String a : buffer)
            {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(a);

                if (matcher.find())
                {
                    writer.write(a + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
