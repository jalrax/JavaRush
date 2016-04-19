package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String a = args[1];
        String b = args[2];
        FileInputStream inputStream;
        FileOutputStream outputStream;

        if (args[0].equals("-e"))
        {
            inputStream = new FileInputStream(a);
            outputStream = new FileOutputStream(b);
            while (inputStream.available() > 0)
            {
                int x = inputStream.read() + 1;
                outputStream.write(x);
            }
            inputStream.close();
            outputStream.close();
        } else if (args[0].equals("-d"))
        {
            inputStream = new FileInputStream(a);
            outputStream = new FileOutputStream(b);
            while (inputStream.available() > 0)
            {
                int x = inputStream.read() - 1;
                outputStream.write(x);
            }
            inputStream.close();
            outputStream.close();
        } else
            System.out.println("Argument wrong type");
    }
}
