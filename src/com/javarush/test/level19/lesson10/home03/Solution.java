package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        String file = args[0];
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                String nameAndDate = reader.readLine();
                String name = nameAndDate.replaceAll("[\\p{Digit}]", "").replaceAll("   ", "");
                String[] date = nameAndDate.replaceAll("[^\\p{Digit} ]", "").split(" ");
                Date fullDate = new GregorianCalendar(Integer.parseInt(date[date.length-1]), Integer.parseInt(date[date.length-2]) - 1, Integer.parseInt(date[date.length-3])).getTime();
                PEOPLE.add(new Person(name, fullDate));
            }
            reader.close();


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
