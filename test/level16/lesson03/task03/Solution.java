package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;


/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution
{
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args)
    {
        //Add your code here - добавьте свой код тут
        Runnable sp1 = new SpecialThread();
        list.add(new Thread(sp1));
        Runnable sp11 = new SpecialThread();
        list.add(new Thread(sp1));
        Runnable sp12 = new SpecialThread();
        list.add(new Thread(sp1));
        Runnable sp13 = new SpecialThread();
        list.add(new Thread(sp1));
        Runnable sp14 = new SpecialThread();
        list.add(new Thread(sp1));
    }

    public static class SpecialThread implements Runnable
    {

        public void run()
        {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
