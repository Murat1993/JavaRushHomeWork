package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами.
В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, int x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, char x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, double x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, boolean x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, ArrayList<String> list) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(list);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, short x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, float x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Integer x) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }




}
