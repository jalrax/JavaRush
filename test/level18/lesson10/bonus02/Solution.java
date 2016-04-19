package com.javarush.test.level18.lesson10.bonus02;

    /* Прайсы
    CrUD для таблицы внутри файла
    Считать с консоли имя файла для операций CrUD
    Программа запускается со следующим набором параметров:
    -c productName price quantity
    Значения параметров:
    где id - 8 символов
    productName - название товара, 30 chars (60 bytes)
    price - цена, 8 символов
    quantity - количество, 4 символа
    -c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id
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
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            final String FILENAME = bufferedReader.readLine();
            String prepared;
            bufferedReader.close();
            if (args.length > 0)
            {
                prepared = getNewID(FILENAME).append(getData(args)).toString();
                prepared = prepared.replace('\u0000', '\u0020'); //Для валидатора JavaRush
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME, true)));
                writer.write(prepared);
                writer.write(System.lineSeparator());
                writer.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    public static StringBuilder getData(String[] args)
    {
        StringBuilder finalData = new StringBuilder();
        StringBuilder productName = new StringBuilder();
        StringBuilder price = new StringBuilder();
        StringBuilder quantity = new StringBuilder();
        for (int i = 1; i < args.length - 2; i++)
        {
            productName.append(args[i].concat(" "));
        }
        productName.setLength(30);
        price.append(args[args.length - 2]);
        price.setLength(8);
        quantity.append(args[args.length - 1]);
        quantity.setLength(4);
        finalData.append(productName).append(price).append(quantity);
        return finalData;
    }

    public static StringBuilder getNewID(String filename) throws IOException
    {
        ArrayList<Integer> IDList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        StringBuilder id;
        String tmp;
        while ((tmp = bufferedReader.readLine()) != null)
        {
            IDList.add(Integer.parseInt(tmp.substring(0, 8).trim()));
        }
        if (IDList.isEmpty())
        {
            id = new StringBuilder("1");
            id.setLength(8);
        } else
        {
            Integer newID = Collections.max(IDList) + 1;
            id = new StringBuilder(newID.toString());
            id.setLength(8);
        }
        return id;
    }
}