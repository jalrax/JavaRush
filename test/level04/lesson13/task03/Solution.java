package com.javarush.test.level04.lesson13.task03;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a, b;
        for (a = 0; a <= 10; a = a + 1)
        {
            for (b = 0; b != a; b = b + 1)
            {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
