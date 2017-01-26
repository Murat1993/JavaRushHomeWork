package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
            FileInputStream fileInputStream1 = new FileInputStream(file1);

            int[] bytes = new int[fileInputStream1.available()];
            int i = 0;
            while (fileInputStream1.available() > 0) {
                bytes[i] = fileInputStream1.read();
                i++;
            }
            fileInputStream1.close();


            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);

            if (bytes.length % 2 == 0) {
                int middle = bytes.length / 2 - 1;
                for (int j = 0; j <= middle; j++) {
                    fileOutputStream2.write(bytes[j]);
                }
                fileOutputStream2.close();

                for (int k = middle + 1; k < bytes.length; k++) {
                    fileOutputStream3.write(bytes[k]);
                }
                fileOutputStream3.close();
            }

            else {
                int middle = ((bytes.length - 1) / 2 - 1) + 1;
                for (int z = 0; z <= middle; z++) {
                    fileOutputStream2.write(bytes[z]);
                }
                fileOutputStream2.close();

                for (int i1 = middle + 1; i1 < bytes.length; i1++) {
                    fileOutputStream3.write(bytes[i1]);
                }
                fileOutputStream3.close();

            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
