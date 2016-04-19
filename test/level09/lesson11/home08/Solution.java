package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        Random random = new Random();

        int[] array1 = new int[5];
        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = random.nextInt(99);
        }
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[2];
        for (int i = 0; i < array2.length; i++)
        {
            array2[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[4];
        for (int i = 0; i < array3.length; i++)
        {
            array3[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array3));

        int[] array4 = new int[7];
        for (int i = 0; i < array4.length; i++)
        {
            array4[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array4));

        int[] array5 = new int[0];
        for (int i = 0; i < array5.length; i++)
        {
            array5[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array5));

        ArrayList<int[]> createdList = new ArrayList<>();
        createdList.add(array1);
        createdList.add(array2);
        createdList.add(array3);
        createdList.add(array4);
        createdList.add(array5);

        return createdList;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array : list)
        {
            for (int x : array)
            {
                System.out.println(x);
            }
        }
    }
}
