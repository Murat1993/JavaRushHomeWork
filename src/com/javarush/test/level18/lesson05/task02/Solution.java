package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String file = reader.readLine();
            reader.close();
            FileInputStream fileInputStream = new FileInputStream(file);
            int count = 0;

            while (fileInputStream.available() > 0) {
                int oneByte = fileInputStream.read();
                if (oneByte == (int)',') {
                    count += 1;
                }
            }
            fileInputStream.close();
            System.out.println(count);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
