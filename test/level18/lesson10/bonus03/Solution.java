package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            ArrayList<String> fileLine = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String s;
            while ((s = fileReader.readLine()) != null)
            {
                fileLine.add(s);
            }
            int intID = Integer.parseInt(args[1]);
            for (int i = 0; i < fileLine.size(); i++)
            {
                try
                {
                    if (intID == Integer.parseInt(fileLine.get(i).substring(0, 8).trim().replace(" ", "")))
                    {
                        if ("-d".equals(args[0]))
                            fileLine.remove(i);
                        if ("-u".equals(args[0]))
                        {
                            String str = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                            fileLine.add(i, str);
                            fileLine.remove(i + 1);
                            break;
                        }
                    }
                }
                catch (RuntimeException re)
                {
                }
            }
            new FileWriter(fileName).close();
            for (String in : fileLine)
            {
                writer.write(in);
                writer.newLine();
                writer.flush();
            }
            br.close();
            fileReader.close();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}