package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них.
 Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        int max = arr[0];

        for(int i = 0; i < 3; i++) {
            if(max < arr[i]) max = arr[i];
        }

        int min = arr[0];

        for(int i = 0; i < 3; i++) {
            if(min > arr[i]) min = arr[i];
        }

        int mid = 0;

        for(int i = 0; i < 3; i++) {
            if(arr[i] != min && arr[i] != max) mid = arr[i];
        }

        System.out.println(mid);
    }
}
