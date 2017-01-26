package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных
и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];

        int bigThenZero = 0;
        int lessThenZero = 0;

        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        for (int i = 0; i < 3; i++)
        {
            if (arr[i] > 0)
            {
                bigThenZero += 1;
            } else
            {
                lessThenZero += 1;
            }
        }

            System.out.println("количество отрицательных чисел: " + lessThenZero);
            System.out.println("количество положительных чисел: " + bigThenZero);
    }
}