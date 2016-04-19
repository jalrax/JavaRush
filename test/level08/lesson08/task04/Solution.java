package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("A", new Date("JUNE 11 1980"));
        map.put("B", new Date("JUNE 12 1980"));
        map.put("C", new Date("JUNE 13 1980"));
        map.put("D", new Date("JUNE 14 1980"));
        map.put("E", new Date("JUNE 15 1980"));
        map.put("R", new Date("JUNE 17 1980"));
        map.put("T", new Date("JUNE 16 1980"));
        map.put("Q", new Date("JUNE 18 1980"));
        map.put("W", new Date("MAY 1 1980"));
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> tmp = map.entrySet().iterator();
        while (tmp.hasNext())
        {
            Date month = tmp.next().getValue();
            if (month.getMonth() > 4 && month.getMonth() < 8)
            {
                tmp.remove();
            }

        }
    }
}
