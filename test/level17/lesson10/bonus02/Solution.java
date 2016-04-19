package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static synchronized void main(String[] args)
    {
        if (args[0].equals("-c"))
            create(args);
        else if (args[0].equals("-u"))
            update(args);
        else if (args[0].equals("-d"))
            delete(args);
        else if (args[0].equals("-i"))
            info(args);
        else
            System.out.println("Не в этой программе");
    }

    private synchronized static void create(String[] args)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i += 3)
        {
            String name = args[i];
            String sex = args[i + 1];
            String bd = args[i + 2];
            try
            {
                if (sex.equals("м"))
                {
                    allPeople.add(Person.createMale(name, format.parse(bd)));
                } else if (sex.equals("ж"))
                    allPeople.add(Person.createFemale(name, format.parse(bd)));
                else
                {
                    System.out.println("средний род у МЕТРО");
                    break;
                }
                System.out.print(allPeople.size() - 1 + " ");
            }
            catch (ParseException e)
            {
                System.out.println("хреновая дата");
            }
        }
    }

    private synchronized static void update(String[] args)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i += 4)
        {
            String id = args[i];
            String name = args[i + 1];
            String sex = args[i + 2];
            String bd = args[i + 3];
            Person person = allPeople.get(Integer.parseInt(id));
            person.setName(name);
            try
            {
                person.setBirthDay(format.parse(bd));
            }
            catch (ParseException e)
            {
                System.out.println("Нет - хреновая дата");
            }
            if (sex.equals("м")) person.setSex(Sex.MALE);
            if (sex.equals("ж")) person.setSex(Sex.FEMALE);
            allPeople.set(Integer.parseInt(id), person);
        }
    }

    private synchronized static void delete(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            if (i < allPeople.size())
            {
                allPeople.set(Integer.parseInt(args[i]), null);
            } else
            {
                System.out.println("Нет человека с id " + i);
            }
        }
    }

    private synchronized static void info(String[] args)
    {
        for (int i = 1; i < args.length; i++)
        {
            if (i < allPeople.size())
            {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Date bd1 = person.getBirthDay();
                if (person.getSex().equals(Sex.MALE))
                    System.out.println(person.getName() + " м " + format1.format(bd1));
                else if (person.getSex().equals(Sex.FEMALE))
                    System.out.println(person.getName() + " ж " + format1.format(bd1));
            } else
            {
                System.out.println("Нет человека с id " + i);
            }
        }
    }
    //start here - начни тут
}