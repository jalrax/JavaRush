package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.equals("exit"))
        {
            ReadThread readThread = new ReadThread(line);
            readThread.start();
            readThread.join();
            line = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName) throws IOException
        {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                Map<Integer, Integer> map = new TreeMap();
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0)
                {
                    int a = inputStream.read();
                    if (map.get(a) == null) map.put(a, 1);
                    else map.put(a, map.get(a) + 1);
                }
                int maxValue = 0;
                int symbol = 0;
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    Integer key = pair.getKey();
                    Integer value = pair.getValue();
                    if (maxValue < value)
                    {
                        maxValue = value;
                        symbol = key;
                    }
                }
                inputStream.close();
                {
                    if (maxValue != 0)
                        resultMap.put(fileName, symbol);
                    else resultMap.put(fileName, null);
                }
            }
            catch (IOException e)
            {
            }
        }
    }
}