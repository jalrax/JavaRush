package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //напишите тут ваш код
    Friend friend = new Friend();
    private String friendName = "Barsik";
    private int friendAge = 12;
    private String friendSex = "male";

    public void initialize(String name)
    {
        this.friendName = name;
    }

    public void initialize(String name, int age)
    {
        this.friendName = name;
        this.friendAge = age;
    }

    public void initialize(String name, String male, int age)
    {
        this.friendName = name;
        this.friendAge = age;
        this.friendSex = male;
    }
}

