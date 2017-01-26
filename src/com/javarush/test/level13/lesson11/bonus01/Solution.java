package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/


import java.io.*;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try
        {
            String srcFile = reader1.readLine();
            BufferedReader reader2 = new BufferedReader(new FileReader(srcFile));
            String text;

            while ((text = reader2.readLine()) != null) {
                if (Integer.parseInt(text) % 2 == 0)
                {
                    list.add(Integer.parseInt(text));
                }
            }


            int[] sortedList = new int[list.size()];
            for (int i = 0; i < sortedList.length; i++) {
                sortedList[i] = list.get(i);
            }

            for(int i = sortedList.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){

                    if( sortedList[j] > sortedList[j+1] ){
                        int tmp = sortedList[j];
                        sortedList[j] = sortedList[j+1];
                        sortedList[j+1] = tmp;
                    }
                }
            }

            for (int i : sortedList) {
                System.out.println(i);
            }

            reader1.close();
            reader2.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
