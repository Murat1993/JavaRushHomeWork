package com.javarush.test.level18.lesson03.task01;


/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file);

        int[] bytes = new int[fileInputStream.available()];
        int i = 0;
        while (fileInputStream.available() > 0) {
            bytes[i] = fileInputStream.read();
            i++;
        }
        fileInputStream.close();



        int max = bytes[0];
        for (int j = 1; j < bytes.length; j++) {
            if (max < bytes[j]) {
                max = bytes[j];
            }
        }

        System.out.println(max);

    }
}
