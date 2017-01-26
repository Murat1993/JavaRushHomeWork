package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        //напишите тут ваш код
        Map<Character, Integer> list1 = new HashMap<>();
        for (Character character : alphabet) {
            list1.put(character, 0);
        }

        for (String string : list) {
            char[] charArray = string.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (Map.Entry<Character, Integer> pair : list1.entrySet()) {
                    Character key = pair.getKey();
                    Integer value = pair.getValue();

                    if (charArray[i] == key) {
                           value += 1;
                           list1.put(key, value);
                    }
                }
            }
        }


        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + list1.get(abcArray[i]));
        }
    }

}
