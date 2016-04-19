package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human("Ded1", true, 55, null, null);
        Human ded2 = new Human("Ded2", true, 65, null, null);
        Human baba1 = new Human("Baba1", false, 54, null, null);
        Human baba2 = new Human("Baba2", false, 64, null, null);

        Human otec = new Human("Otec", true, 35, ded1, baba1);
        Human mat = new Human("Mat", false, 34, ded2, baba2);

        Human reb1 = new Human("Reb1", true, 15, otec, mat);
        Human reb2 = new Human("Reb2", true, 14, otec, mat);
        Human reb3 = new Human("Reb3", false, 13, otec, mat);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(otec);
        System.out.println(mat);
        System.out.println(reb1);
        System.out.println(reb2);
        System.out.println(reb3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
