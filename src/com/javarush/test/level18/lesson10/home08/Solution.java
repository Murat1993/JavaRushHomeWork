package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        try
        {
            while (!(fileName = reader.readLine()).equals("exit")) {
                Thread thread = new ReadThread(fileName);
                thread.start();
                thread.join();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);

                Map<Integer, Integer> characterIntegerMap = new TreeMap<>();
                while (fileInputStream.available() > 0)
                {
                    int oneByte = fileInputStream.read();

                    if (!characterIntegerMap.containsKey(oneByte))
                    {
                        characterIntegerMap.put(oneByte, 1);
                    }
                    else
                    {
                        characterIntegerMap.put(oneByte, characterIntegerMap.get(oneByte) + 1);
                    }
                }
                fileInputStream.close();

                int maxInFile = 0;
                for (Map.Entry<Integer, Integer> pair : characterIntegerMap.entrySet()) {
                    if (pair.getValue() > maxInFile) {
                        maxInFile = pair.getValue();
                    }
                }

                for (Map.Entry<Integer, Integer> pair : characterIntegerMap.entrySet()) {
                    if (pair.getValue() == maxInFile) {
                        resultMap.put(fileName, pair.getKey());
                    }
                }


            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
