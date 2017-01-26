package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла,
а потом дописать в первый файл содержимое третьего файла
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
            String file3 = reader.readLine();
            reader.close();

            FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            FileInputStream fileInputStream3 = new FileInputStream(file3);

            int[] allData = new int[fileInputStream2.available() + fileInputStream3.available()];
            int i = 0;
            while (fileInputStream2.available() > 0) {
                allData[i] = fileInputStream2.read();
                i++;
            }
            fileInputStream2.close();

            while (fileInputStream3.available() > 0) {
                allData[i] = fileInputStream3.read();
                i++;
            }
            fileInputStream3.close();

            for (int j = 0; j < allData.length; j++) {
                fileOutputStream1.write(allData[j]);
            }
            fileOutputStream1.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
