package com.javarush.test.level10.lesson11.home04;
    /* Большая зарплата
    Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
    Образец:
    Я не хочу изучать Java, я хочу большую зарплату
     не хочу изучать Java, я хочу большую зарплату
    не хочу изучать Java, я хочу большую зарплату
    е хочу изучать Java, я хочу большую зарплату
     хочу изучать Java, я хочу большую зарплату
    хочу изучать Java, я хочу большую зарплату
    …
    */

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        ArrayList<Character> chr = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            chr.add(s.charAt(i));
        }
        for (int i = 0; i < 40; i++)
        {
            printingarr(chr);
            chr.remove(0);
        }
        //напишите тут ваш код
    }

    public static void printingarr(ArrayList<Character> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.print(arr.get(i));
        }
        System.out.println();
    }
}