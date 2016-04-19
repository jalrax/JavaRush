package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.LinkedList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        /* String s1 = "d:/test01.txt";
         String s2 = "d:/test02.txt";*/

        InputStream inputStream1 = new FileInputStream(s1);
        InputStream inputStream2 = new FileInputStream(s2);

        while (inputStream1.available() > 0)
        {
            int data = inputStream1.read();
            list.add(data);
        }
        System.out.println(String.valueOf(list));

        OutputStream outputStream = new FileOutputStream(s1);

        while (inputStream2.available() > 0)
        {
            int data = inputStream2.read();
            outputStream.write(data);
        }

        for (int a : list)
        {
            outputStream.write(a);
        }

        inputStream1.close();
        inputStream2.close();
        outputStream.close();
        reader.close();
    }
}
