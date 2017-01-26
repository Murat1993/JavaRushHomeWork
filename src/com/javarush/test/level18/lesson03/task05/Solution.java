package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(file);


        Map<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            map.put(fileInputStream.read(), 0);
        }
        fileInputStream.close();

        int[] bytes = new int[map.size()];

        int k = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            bytes[k] = pair.getKey();
            k++;
        }


        for(int i = bytes.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( bytes[j] > bytes[j+1] ){
                int tmp = bytes[j];
                bytes[j] = bytes[j+1];
                bytes[j+1] = tmp;
                }
            }
        }

        for (int i : bytes) {
            System.out.print(i + " ");
        }

    }
}
