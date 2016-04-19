package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        String name = "";
        int day;
        int month;
        int year;
        Calendar date = new GregorianCalendar();
        Date date1;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = null;

        while ((tmp = reader.readLine()) != null)
        {
            String[] buffer = tmp.split(" ");
            year = Integer.parseInt(buffer[buffer.length - 1]);
            month = Integer.parseInt(buffer[buffer.length - 2]);
            day = Integer.parseInt(buffer[buffer.length - 3]);

            for (int i = 0; i < buffer.length - 3; i++)
            {
                name += buffer[i] + " ";
            }
            date.set(year, month - 1, day);
            date1 = date.getTime();

            PEOPLE.add(new Person(name.trim(), date1));
            name = "";
        }
        reader.close();

        for (Person a : PEOPLE)
        {
            System.out.println(a.getName() + " " + a.getBirthday());
        }
    }
}
