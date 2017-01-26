package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream myStream = new PrintStream(outputStream);

        System.setOut(myStream);
        testString.printSomething();

        String fullString1 = outputStream.toString();
        String[] fullString = outputStream.toString().split(" ");
        String operation = "";
        String forSplit = "";
        for (String string : fullString) {
            if (string.contains("+")) {
                operation = "+";
                forSplit = "\\+";
                break;
            } else if (string.contains("-")) {
                operation = "-";
                forSplit = "-";
                break;
            } else if (string.contains("*")) {
                operation = "*";
                forSplit = "\\*";
                break;
            }
        }
        String[] twoParts = fullString1.split(forSplit);
        int numberOne = 0, numberTwo = 0;
        for (int i = 0; i < twoParts.length; i++) {
            if (i == 0) {
                numberOne = Integer.parseInt(twoParts[i].replaceAll("[^\\p{Digit}]", ""));
            } else if (i == 1) {
                numberTwo = Integer.parseInt(twoParts[i].replaceAll("[^\\p{Digit}]", ""));
            }
        }

        int solution = 0;

        switch (operation)
        {
            case "+":
                solution = numberOne + numberTwo;
                break;
            case "-":
                solution = numberOne - numberTwo;
                break;
            case "*":
                solution = numberOne * numberTwo;
                break;
        }

        System.setOut(defaultStream);
        System.out.println(fullString1.replace("\n", Integer.toString(solution)));






    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

