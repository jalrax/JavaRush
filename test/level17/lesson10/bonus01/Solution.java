package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args.length == 4 && args[0].equals("-c"))
        {
            Date date = format.parse(args[3]);
            if (args[2].equals("м"))
            {
                allPeople.add(Person.createMale(args[1], date));
            } else if (args[2].equals("ж"))
            {
                allPeople.add(Person.createFemale(args[1], date));
            }
            System.out.println(allPeople.size() - 1);
        } else if (args.length == 5 && args[0].equals("-u"))
        {
            int id = Integer.parseInt(args[1]);
            Date date = format.parse(args[4]);
            allPeople.get(id).setName(args[2]);
            if (args[3].equals("м"))
            {
                allPeople.get(id).setSex(Sex.MALE);
            } else if (args[3].equals("ж"))
            {
                allPeople.get(id).setSex(Sex.FEMALE);
            }
            allPeople.get(id).setBirthDay(date);
        } else if (args.length == 2 && args[0].equals("-d"))
        {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
        } else if (args.length == 2 && args[0].equals("-i"))
        {
            int id = Integer.parseInt(args[1]);
            String name = allPeople.get(id).getName();
            String sex = "";
            if (allPeople.get(id).getSex() == Sex.MALE)
            {
                sex = "м";
            } else if (allPeople.get(id).getSex() == Sex.FEMALE)
            {
                sex = "ж";
            }
            Date date = allPeople.get(id).getBirthDay();
            System.out.println(name + " " + sex + " " + dateFormat1.format(date));
        }
    }
}