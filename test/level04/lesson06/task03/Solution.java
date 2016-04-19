package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();

        int b1 = Integer.parseInt(a1);
        int b2 = Integer.parseInt(a2);
        int b3 = Integer.parseInt(a3);

        if (b1 > b2 && b1 > b3 && b2 > b3)
            System.out.print(b1 + " " + b2 + " " + b3);
        if (b1 > b2 && b1 > b3 && b3 > b2)
            System.out.print(b1 + " " + b3 + " " + b2);
        if (b2 > b1 && b2 > b3 && b1 > b3)
            System.out.print(b2 + " " + b1 + " " + b3);
        if (b2 > b1 && b2 > b3 && b3 > b1)
            System.out.print(b1 + " " + b3 + " " + b1);
        if (b3 > b1 && b3 > b2 && b1 > b2)
            System.out.print(b3 + " " + b1 + " " + b2);
        if (b3 > b1 && b3 > b2 && b2 > b1)
            System.out.print(b3 + " " + b2 + " " + b1);

    }
}
