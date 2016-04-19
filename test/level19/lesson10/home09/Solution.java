package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Рекламный текст: "JavaRush - курсы Java онлайн"
Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream realStream = System.out;

        ByteArrayOutputStream failContainer = new ByteArrayOutputStream();

        PrintStream failStream = new PrintStream(failContainer);
        System.setOut(failStream);
        testString.printSomething();

        String container = failContainer.toString();
        int count = 1;
        System.setOut(realStream);

        String[] words = container.split("\n");


        int i;
        for (i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
            if (count % 2 == 0)
            {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            count++;
        }

    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}