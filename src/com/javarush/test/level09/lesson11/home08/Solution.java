package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] i = { 1, 2, 3, 5, 4 };
        int[] j = { 1, 2 };
        int[] x = {1, 2, 3, 5};
        int[] z = {1, 2, 3, 5, 6, 7, 8};
        int[] y = {};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        list.add(x);
        list.add(z);
        list.add(y);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
