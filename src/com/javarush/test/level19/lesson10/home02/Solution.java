package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String file = args[0];
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Map<String, Double> map = new TreeMap<>();

            while (reader.ready()) {
                String[] nameAndNumber = reader.readLine().split(" ");
                if (!map.containsKey(nameAndNumber[0])) {
                    map.put(nameAndNumber[0], Double.parseDouble(nameAndNumber[1]));
                } else {
                    map.put(nameAndNumber[0], map.get(nameAndNumber[0]) + Double.parseDouble(nameAndNumber[1]));
                }
            }
            reader.close();


            Double maxNumber = Collections.max(map.values());
            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (Objects.equals(maxNumber, pair.getValue())) {
                    System.out.println(pair.getKey());
                }
            }
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
