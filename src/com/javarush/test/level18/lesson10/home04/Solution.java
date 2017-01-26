package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            FileInputStream fileInputStream1 = new FileInputStream(file1);
            int[] file1Data = new int[fileInputStream1.available()];
            int i = 0;
            while (fileInputStream1.available() > 0) {
                file1Data[i] = fileInputStream1.read();
                i++;
            }
            fileInputStream1.close();

            FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);

            while (fileInputStream2.available() > 0) {
                fileOutputStream1.write(fileInputStream2.read());
            }
            fileInputStream2.close();

            for (int j = 0; j < file1Data.length; j++) {
                fileOutputStream1.write(file1Data[j]);
            }
            fileOutputStream1.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
