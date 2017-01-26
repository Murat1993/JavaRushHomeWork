package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2 = args[1];

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String[] words = reader.readLine().split("[ ]");
                for (String word : words)
                {
                    if (word.matches("[a-zA-Zа-яА-Я0-9\\p{Punct}]{7,}"))
                    {
                        list.add(word);
                    }
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    writer.write(list.get(i));
                    writer.flush();
                } else {
                    writer.write(list.get(i) + ",");
                    writer.flush();
                }
            }

            writer.close();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
