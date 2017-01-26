package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
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



        int min = bytes[0];
        for (int j = 1; j < bytes.length; j++) {
            if (min > bytes[j]) {
                min = bytes[j];
            }
        }

        System.out.println(min);
    }
}
