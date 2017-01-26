package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
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
            int[] bytes = new int[fileInputStream1.available()];
            int i = 0;
            while (fileInputStream1.available() > 0) {
                bytes[i] = fileInputStream1.read();
                i++;
            }
            fileInputStream1.close();

            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            for (int i1 = bytes.length - 1; i1 >= 0; i1--) {
                fileOutputStream2.write(bytes[i1]);
            }
            fileOutputStream2.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
