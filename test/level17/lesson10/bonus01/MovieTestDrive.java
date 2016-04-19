package com.javarush.test.level17.lesson10.bonus01;

/**
 * Created by repin.s on 26.02.2016.
 */
public class MovieTestDrive
{
    public void main(String[] args)
    {
        Movie one = new Movie();
        one.title = "ÐšÐ°Ðº ÐŸÑ€Ð¾Ð³Ð¾Ñ€ÐµÑ‚ÑŒ Ð½Ð° ÐÐºÑ†Ð¸ÑÑ…";
        one.genre = "Ð¢Ñ€Ð°Ð³ÐµÐ´Ð¸Ñ";
        one.rating = -2;
        Movie two = new Movie();
        two.title = "ÐŸÐ¾Ñ‚ÐµÑ€ÑÐ½Ð½Ñ‹Ðµ Ð² ÐžÑ„Ð¸ÑÐµ";
        two.genre = "ÐšÐ¾Ð¼ÐµÐ´Ð¸Ñ";
        two.rating = 5;
        two.playIt();
        Movie three = new Movie();
        three.title = "Ð‘Ð°Ð¹Ñ‚-ÐšÐ»ÑƒÐ±";
        three.genre = "Ð¢Ñ€Ð°Ð³ÐµÐ´Ð¸Ñ, Ð½Ð¾ Ð² Ñ†ÐµÐ»Ð¾Ð¼ Ð²ÐµÑÐµÐ»Ð°Ñ";
        three.rating = 127;
    }
}


