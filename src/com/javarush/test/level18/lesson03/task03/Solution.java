package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file);

        int[] bytes = new int[fileInputStream.available()];
        int i = 0;
        while (fileInputStream.available() > 0) {
            bytes[i] = fileInputStream.read();
            i++;
        }
        fileInputStream.close();


        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < bytes.length; j++) {
            map.put(bytes[j], 0);
        }

        for (int j = 0; j < bytes.length; j++) {
            if (map.containsKey(bytes[j])) {
                map.put(bytes[j], map.get(bytes[j]) + 1);
            }
        }


        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int value = pair.getValue();
            if (max < value) {
                max = value;
            }
        }


        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == max) {
                System.out.print(key + " ");
            }
        }
    }
}
