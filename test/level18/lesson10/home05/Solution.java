package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader lineReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter lineWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        String[] strings = null;
        String data = "";

        while (lineReader.ready())
        {
            data = lineReader.readLine();
        }

        strings = data.split(" ");

        String result = "";
        int[] itog = new int[strings.length];
        for (int i = 0; i < strings.length; i++)
        {
            itog[i] = Math.round(Float.parseFloat(strings[i]));
            result += itog[i] + " ";
        }

        System.out.println(result);
        lineWriter.write(result);

        reader.close();
        lineReader.close();
        lineWriter.close();
    }
}
