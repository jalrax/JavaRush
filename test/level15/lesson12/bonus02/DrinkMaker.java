package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by repin.s on 03.02.2016.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();

    abstract void putIngredient();

    abstract void pour();

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
