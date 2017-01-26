package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(reader.readLine());
        int secondNum = Integer.parseInt(reader.readLine());


        if (firstNum <= secondNum) {
            for (int i = firstNum; i >= 1; i--) {
                if (firstNum % i == 0 && secondNum % i == 0) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            for (int i = secondNum; i >= 1; i--) {
                if (firstNum % i == 0 && secondNum % i == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
