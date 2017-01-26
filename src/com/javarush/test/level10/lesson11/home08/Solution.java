package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        ArrayList<String> list5 = new ArrayList<>();

        list1.add("asdf");
        list2.add("asdf");
        list3.add("asdf");
        list4.add("asdf");
        list5.add("asdf");
        ArrayList<String>[] arrayListsOfStringList = new ArrayList[5];
        arrayListsOfStringList[1] = list1;
        arrayListsOfStringList[2] = list2;
        arrayListsOfStringList[3] = list3;
        arrayListsOfStringList[4] = list4;
        arrayListsOfStringList[0] = list5;


        return arrayListsOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}