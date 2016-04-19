package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Sim");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        ArrayList<String> listName = new ArrayList<String>();
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String name = pair.getValue();
            listName.add(name);
        }
        int[] count = new int[listName.size()];
        for (int i = 0; i < count.length; i++)
        {
            count[i] = 0;
        }
        ArrayList<String> listName2 = listName;
        for (int i = 0; i < listName.size(); i++)
        {
            for (int j = 0; j < listName2.size(); j++)
            {
                if (listName.get(i).equals(listName2.get(j)))
                    count[i]++;
            }
            if (count[i] > 1)
            {
                removeItemFromMapByValue(map, listName.get(i));
            }
        }
    }


    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
