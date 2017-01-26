package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Метод в try..catch
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
Обернуть все тело (весь код внутри readData, кроме объявления списка,
 где будут храниться числа и BufferedReader -
 а) этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа,
 то метод должен перехватить исключение и вывести на экран все введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.
*/

public class Solution
{
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            for (int i = 0; i < 10; i++) {
                int j = sc.nextInt();
                list.add(j);
            }
        } catch (Exception e)  {
            for (Integer aList : list)
            {
                System.out.println(aList);
            }
        }
    }
}
