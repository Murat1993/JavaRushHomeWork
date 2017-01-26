package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно заменить функциональность программы
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
Потом она конвертирует строки в верхний регистр (Мама превращается в МАМА) и выводит их на экран.


Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
Потом программа строит новый список.
Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
Программа выводит содержимое нового списка на экран.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).length());
            if (list.get(i).length() % 2 == 0) {
                //System.out.println(list.get(i));
                String str = list.get(i);
                str += " ";
                str += list.get(i);
                list.remove(i);
                list.add(i, str);
            } else if (list.get(i).length() % 3 == 0 || list.get(i).length() == 1) {
                String str1 = list.get(i);
                str1 += " ";
                str1 += list.get(i);
                str1 += " ";
                str1 += list.get(i);
                list.remove(i);
                list.add(i, str1);
            }
        }

/*
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 0) {
                String string1 = list.get(i);
                string1 += " ";
                string1 += list.get(i);
                list.add(i, string1);

            } else
            {
                if (list.get(i).length() % 3 == 0)
                {
                    String string = list.get(i);
                    string += " ";
                    string += list.get(i);
                    string += " ";
                    string += list.get(i);
                    list.add(i, string);
                }
            }
        }*/


        for (String aList : list)
        {
            System.out.println(aList);
        }
    }
}
