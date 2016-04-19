package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array1 = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array1[i] = Integer.parseInt(reader.readLine());
        }

        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++)
        {
            array2[i] = array1[0]++;
        }

        int[] array3 = new int[10];
        for (int i = 0; i < 10; i++)
        {
            array3[i] = array1[10 + i];
        }

        for (int i = 0; i < 10; i++)
            System.out.println(array3[i]);
    }
}
