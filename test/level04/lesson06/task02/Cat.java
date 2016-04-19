package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cat
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();
        String a4 = reader.readLine();

        int b1 = Integer.parseInt(a1);
        int b2 = Integer.parseInt(a2);
        int b3 = Integer.parseInt(a3);
        int b4 = Integer.parseInt(a4);


        if (b1 < b2 && b1 < b3 && b1 < b4)
            System.out.print(b1);
        if (b2 < b1 && b2 < b3 && b2 < b4)
            System.out.print(b2);
        if (b3 < b1 && b3 < b2 && b3 < b4)
            System.out.print(b3);
        if (b4 < b1 && b4 < b2 && b4 < b3)
            System.out.print(b4);

    }
}
