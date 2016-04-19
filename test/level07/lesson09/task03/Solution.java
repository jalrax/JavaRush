package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        list.add(0, "мама");
        list.add(1, "мыла");
        list.add(2, "раму");

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == "мама")
                list.add(i + 1, "именно");

            else if (list.get(i) == "мыла")
                list.add(i + 1, "именно");

            else if (list.get(i) == "раму")
                list.add(i + 1, "именно");
        }

        for (String aList : list)
        {
            System.out.println(aList);
        }
    }
}
