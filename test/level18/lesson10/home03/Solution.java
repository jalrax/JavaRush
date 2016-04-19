package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s0 = reader.readLine();
        String s1 = reader.readLine();
        String s2 = reader.readLine();

        OutputStream outputStream = new FileOutputStream(s0);
        InputStream inputStream1 = new FileInputStream(s1);
        InputStream inputStream2 = new FileInputStream(s2);

        while (inputStream1.available() > 0)
        {
            int data = inputStream1.read();
            outputStream.write(data);
        }
        while (inputStream2.available() > 0)
        {
            int data = inputStream2.read();
            outputStream.write(data);
        }
        outputStream.close();
        inputStream1.close();
        inputStream2.close();
        reader.close();
    }
}
