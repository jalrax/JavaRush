package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        br.close();
        String tmp = null;
        BufferedReader reader = new BufferedReader(new FileReader(name));


        while ((tmp = reader.readLine()) != null)
        {
            swap(tmp);
        }
        reader.close();
    }

    public static void swap(String s)
    {
        StringBuilder sb = new StringBuilder(s).reverse();
        String a = sb.toString();
        System.out.println(a);
    }
}
