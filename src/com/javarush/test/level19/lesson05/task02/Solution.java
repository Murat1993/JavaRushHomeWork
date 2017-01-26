package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String file = reader.readLine();
            reader.close();

            Pattern pattern = Pattern.compile("\\bworld\\b", Pattern.CASE_INSENSITIVE);

            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            int i = 0;
            while (fileReader.ready()) {
                Matcher matcher = pattern.matcher(fileReader.readLine());
                while (matcher.find()) {
                    i++;
                }
            }
            fileReader.close();
            System.out.println(i);



        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
