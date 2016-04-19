package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static int getStackTraceDeep()
    {
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) // как я понял так мы перечисляем все методы стек трейса, или я не прав?
        {
            i++;
        }   //Напишите тут ваш код
        System.out.println(i);
        return i++;

    }
}