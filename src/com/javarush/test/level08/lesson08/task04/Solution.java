package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallon", new Date("JUNE 1 1980"));
        map.put("Stalloe", new Date("JUNE 1 1980"));
        map.put("Stallne", new Date("JUNE 1 1980"));
        map.put("Sasdfasd", new Date("JUNE 1 1980"));
        map.put("Stalone", new Date("JUNE 1 1980"));
        map.put("Stllone", new Date("JUNE 1 1980"));
        map.put("Sallone", new Date("JUNE 1 1980"));
        map.put("tallone", new Date("JUNE 1 1980"));
        map.put("Stlone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        ArrayList<String> lastNames = new ArrayList<>();


        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            Date date =  pair.getValue();
            String lastName = pair.getKey();
            if (date.getMonth() == 5 || date.getMonth() == 6 || date.getMonth() == 7) {
                lastNames.add(lastName);
            }
        }

        for (String name : lastNames)
        {
            map.remove(name);
        }

    }
}
