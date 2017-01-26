package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Alferov", "Vasiliy");
        map.put("Barak", "Obama");
        map.put("Asanov", "Artellov");
        map.put("Murat", "Urgant");
        map.put("Ruslan", "Kurmanov");
        map.put("MArat", "Bekenov");
        map.put("Meerim", "Imashkizi");
        map.put("Putin", "Artellov");
        map.put("Dayirbek", "Artellov");
        map.put("Aman", "Osmovaliev");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i = 0;
        for ( Map.Entry<String, String> pair: map.entrySet() )
        {
            String firstName = pair.getValue();
            if (firstName.equals(name)){
                i++;
            }
        }
        return i;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int i = 0;
        for ( Map.Entry<String, String> pair: map.entrySet() )
        {
            String LastName = pair.getKey();
            if (LastName.equals(lastName)){
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        int i = getCountTheSameFirstName(map, "Murat");
        System.out.println(i);
        int j = getCountTheSameLastName(map,"Artellov");
        System.out.println(j);

        for (Map.Entry<String, String> pair: map.entrySet() )
        {
            System.out.println(pair);
        }
    }
}
