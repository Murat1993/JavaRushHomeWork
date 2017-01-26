package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String srcFile = reader.readLine();

            while (true) {
                String line = reader.readLine();
                if (line.equals("exit") || line.isEmpty()) {
                    list.add("exit");
                    break;
                }
                list.add(line);
            }
            reader.close();

            FileWriter fileWriter = new FileWriter(srcFile);
            for (String str : list) {
                if (str.equals("exit")) {
                    fileWriter.write(str);
                } else
                {
                    fileWriter.write(str + '\n');
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
