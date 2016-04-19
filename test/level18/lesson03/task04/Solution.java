package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        int[] bytesArray = new int[256];
        while (file.available() > 0)
        {
            int currentByte = file.read();
            bytesArray[currentByte]++;
        }

        int min = 999;
        for (int x = 0; x < bytesArray.length; x++)
        {
            if (bytesArray[x] < min)
            {
                min = bytesArray[x];
            }
        }
        for (int x = 0; x < bytesArray.length; x++)
        {
            if (bytesArray[x] == min) System.out.print(x + " ");
        }
        reader.close();
        file.close();
    }
}
