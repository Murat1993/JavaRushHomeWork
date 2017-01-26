package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        Map<String, Integer> moths = new HashMap<>();
        moths.put("January", 1);
        moths.put("February", 2);
        moths.put("March", 3);
        moths.put("April", 4);
        moths.put("May", 5);
        moths.put("June", 6);
        moths.put("July", 7);
        moths.put("August", 8);
        moths.put("September", 9);
        moths.put("October", 10);
        moths.put("November", 11);
        moths.put("December", 12);

        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();

        for (Map.Entry<String, Integer> pair : moths.entrySet()) {
            String i = pair.getKey();
            if (i.equals(month)) {
                System.out.println(i + " is " + pair.getValue() + " month");
            }
        }

    }

}
