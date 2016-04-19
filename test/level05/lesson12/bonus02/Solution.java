package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int min1;
        int minimum = min(a, b, c, d, e);
        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e)

    {
        if (b < a && b < c && b < d && b < e)
            a = b;
        if (c < a && c < b && c < d && c < e)
            a = c;
        if (d < a && d < b && d < c && d < e)
            a = d;
        if (e < a && e < b && e < c && e < d)
            a = e;
        return a;
    }
}
