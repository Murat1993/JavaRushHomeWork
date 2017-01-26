package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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

            BufferedReader reader2 = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            while (reader2.ready()) {
                String[] string = reader2.readLine().split(" ");

                for (String string1 : string) {
                    char[] chars = string1.toCharArray();
                    String number = "";
                    for (char cha : chars) {
                        if (Character.isDigit(cha)) {
                            number += cha;
                        }
                        else {
                            number = null;
                            break;
                        }
                    }
                    if (number != null)
                    {
                        writer.write(number + " ");
                        writer.flush();
                    }
                }
                writer.write(System.lineSeparator());
                writer.flush();
            }
            reader2.close();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
