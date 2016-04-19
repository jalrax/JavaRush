package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы

        String name = this.name;
        String surname = this.surname;
        int age = this.age;
        int weight = this.weight;
        int height = this.height;
        boolean sex = this.sex;

        Human(String name)
        {

        }

        Human(String surname, String name)
        {

        }

        Human(int age, int weight)
        {

        }

        Human(int weight)
        {

        }

        Human(int height, int age, int weight)
        {

        }

        Human(boolean sex, int weight, int age)
        {

        }

        Human(boolean sex, int age)
        {

        }

        Human(boolean sex, String name)
        {

        }

        Human(boolean sex, String name, String surname)
        {

        }

        Human(boolean sex, int height, int age, int weight)
        {

        }
    }
}
