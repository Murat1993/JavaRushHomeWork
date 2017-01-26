package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        Map<String, String> addresses = new HashMap<>();
        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.put(city, family);
        }


//        for (Map.Entry<String , String > pair : addresses.entrySet()) {
//            String key = pair.getKey();
//            String value = pair.getValue();
//            System.out.println("Key: " + key + "Value: " + value);
//        }

        //read city
        String city = reader.readLine();

        String family = null;

        for (Map.Entry<String, String> pair : addresses.entrySet()) {

            String key = pair.getKey();
            if (key.equals(city)) {
                family = pair.getValue();
                System.out.println(family);
                break;
            }
        }
    }
}
