package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try
        {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i <= 127; i++) {
                map.put(i, 0);
            }

            FileInputStream fileInputStream = new FileInputStream(args[0]);

            while (fileInputStream.available() > 0) {
                int oneByte = fileInputStream.read();
                if (map.containsKey(oneByte)) {
                    map.put(oneByte, map.get(oneByte) + 1);
                }
            }
            fileInputStream.close();

            for (int i = 0; i <= 127; i++) {
                if (map.get(i) != 0) {
                    System.out.println((char) i + " " + map.get(i));
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
