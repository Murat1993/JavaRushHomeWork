package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> people = new HashMap<>();

        people.put("Bekenov", "Murat");
        people.put("Riskulov", "Suymonkul");
        people.put("Kurmanalive", "Oroz");
        people.put("Kurmanov", "Ruslan");
        people.put("Artellov", "Dayir");
        people.put("Osmonaliev", "Aman");
        people.put("Stalone", "Silvester");
        people.put("Shwartzneeger", "Arnold");
        people.put("Obama", "Barak");
        people.put("Obam", "Barak");

        return people;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        List<String> names = new ArrayList<>();


        for (Map.Entry<String, String> pair1 : map.entrySet())
        {
            String lastNameKey = pair1.getKey();
            String firstNameValue = pair1.getValue();
            for (Map.Entry<String, String> pair2 : map.entrySet())
            {
                if (!lastNameKey.equals(pair2.getKey()))
                {
                    if (pair2.getValue().equals(firstNameValue)) {
                        names.add(pair2.getValue());
                    }
                }
            }
        }

        for (String name : names) {
            removeItemFromMapByValue(map, name);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.printf("Key : " + pair.getKey());
            System.out.println(" Value : " + pair.getValue());
        }
    }
}
