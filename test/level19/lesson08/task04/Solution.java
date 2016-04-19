package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] s = result.split(" ");
        int sum = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
        int sub = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
        int mul = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
        int div = Integer.parseInt(s[0]) / Integer.parseInt(s[2]);

        if ("+".equals(s[1]))
            System.out.print(s[0] + " + " + s[2] + " = " + sum);
        if ("-".equals(s[1]))
            System.out.print(s[0] + " - " + s[2] + " = " + sub);
        if ("*".equals(s[1]))
            System.out.print(s[0] + " * " + s[2] + " = " + mul);
        if ("/".equals(s[1]))
            System.out.print(s[0] + " / " + s[2] + " = " + div);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("31154634 / 63 = ");
        }
    }
}