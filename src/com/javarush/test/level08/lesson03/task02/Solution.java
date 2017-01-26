package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст,
жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String, String> hasMap = new HashMap<String, String>();
        hasMap.put("арбуз", "ягода");
        hasMap.put("банан", "трава");
        hasMap.put("вишня", "ягода");
        hasMap.put("груша", "фрукт");
        hasMap.put("дыня", "овощ");
        hasMap.put("ежевика", "куст");
        hasMap.put("жень-шень", "корень");
        hasMap.put("земляника", "ягода");
        hasMap.put("ирис", "цветок");
        hasMap.put("картофель", "клубень");

        for (Map.Entry<String, String> string : hasMap.entrySet() )
        {
            String key = string.getKey();
            String value = string.getValue();
            System.out.println(key + " - " + value);

        }
    }
}
