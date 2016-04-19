package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s = rd.readLine();
        String tmp = null;
        int count;
        BufferedReader reader = new BufferedReader(new FileReader(s));

        while ((tmp = reader.readLine()) != null)
        {
            String[] buffer = tmp.split(" ");
            count = 0;
            for (int i = 0; i < buffer.length; i++)
            {
                for (int j = 0; j < words.size(); j++)
                {
                    String a = buffer[i];
                    String b = words.get(j);
                    if (a.equals(b))
                    {
                        count++;
                    }
                }
            }
            if (count == 2)
            {
                System.out.println(tmp);
            }
        }
        rd.close();
        reader.close();
    }
}
