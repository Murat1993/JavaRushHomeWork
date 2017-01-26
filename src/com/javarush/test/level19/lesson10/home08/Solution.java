package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String file = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            List<char[]> list  = new ArrayList<>();
            while (fileReader.ready()) {
                 list.add(fileReader.readLine().toCharArray());
            }
            fileReader.close();

            for (int j = 0; j < list.size(); j++) {
                for (int i = list.get(j).length - 1; i >= 0; i--) {
                    System.out.print(list.get(j)[i]);
                }
                if (j != list.size() - 1) {
                    System.out.println();
                }
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
