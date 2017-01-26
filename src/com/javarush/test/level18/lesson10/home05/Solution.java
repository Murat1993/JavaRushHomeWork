package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            String line;
            List<String> stringList = new ArrayList<>();
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            while ((line = reader1.readLine()) != null) {
                stringList.add(line + " \n");
            }
            reader1.close();

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

            for (String string : stringList) {
                for (String str : string.split(" ")) {
                    if (!str.equals("\n"))
                    {
                        double myDouble = Double.valueOf(str);
                        long longPart = (long) myDouble;
                        double fractionalPart = myDouble - longPart;
                        if (longPart >= 0)
                        {
                            if (fractionalPart >= 0.50000)
                            {
                                longPart += 1;
                                fileWriter.write((Long.toString(longPart)) + " ");
                            } else
                            {
                                fileWriter.write((Long.toString(longPart)) + " ");
                            }
                        }
                        else
                        {
                            fractionalPart *= (-1);
                            if (fractionalPart > 0.50000)
                            {
                                longPart -= 1;
                                fileWriter.write((Long.toString(longPart)) + " ");
                            } else
                            {
                                fileWriter.write((Long.toString(longPart)) + " ");
                            }
                        }
                    }
                    else {
                        fileWriter.write("\n");
                    }
                }
            }
            fileWriter.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
