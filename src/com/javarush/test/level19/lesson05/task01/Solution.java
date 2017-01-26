package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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

            FileInputStream fileInputStream = new FileInputStream(file1);
            int[] bytesInFile = new int[fileInputStream.available()];
            int i = 0;
            while (fileInputStream.available() > 0) {
                bytesInFile[i] = fileInputStream.read();
                i++;
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            for (int j = 1; j < bytesInFile.length; j += 2) {
                fileOutputStream.write(bytesInFile[j]);
            }
            fileOutputStream.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
