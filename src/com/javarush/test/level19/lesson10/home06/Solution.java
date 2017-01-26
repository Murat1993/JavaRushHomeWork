package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String file = reader.readLine();
            reader.close();

            List<String> list = new ArrayList<>();

            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] string = line.split("[\\p{Blank}]");
                for (int i = 0; i < string.length; i++)
                {
                    if (string[i].endsWith("."))
                    {
                        string[i] = string[i].replace(".", "");
                        if (string[i].matches("\\p{Digit}+"))
                        {
                            string[i] = string[i].replaceAll("\\p{Punct}", "");
                            if (map.containsKey(Integer.parseInt(string[i])))
                            {
                                string[i] = map.get((int) Double.parseDouble(string[i]));
                            }
                        }
                        string[i] += ".";
                    }

                    else
                    {
                        if (string[i].matches("\\p{Digit}+"))
                        {
                            string[i] = string[i].replaceAll("\\p{Punct}", "");
                            if (map.containsKey(Integer.parseInt(string[i])))
                            {
                                string[i] = map.get((int) Double.parseDouble(string[i]));
                            }
                        }
                    }

                }

                String completed = "";
                for (int i = 0; i < string.length; i++) {
                    if (i != string.length - 1)
                    {
                        completed += string[i] + " ";
                    }
                    else {
                        completed += string[i];
                    }
                }
                list.add(completed);
            }
            fileReader.close();

            for (String s : list) {
                System.out.println(s);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
