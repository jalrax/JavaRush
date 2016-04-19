package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String a = bufferedReader.readLine();
        int count = 0;

        BufferedReader fileReader = new BufferedReader(new FileReader(a));
        while (fileReader.ready())
        {
            String[] s = fileReader.readLine().split("[., !?;:-]");
            for (String elem : s)
            {
                if ("world".equals(elem))
                    count++;
            }
        }
        fileReader.close();
        bufferedReader.close();

        System.out.print(count);
    }
}
