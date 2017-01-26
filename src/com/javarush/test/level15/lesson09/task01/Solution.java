package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(3.15, "a");
        labels.put(3.5, "e");
        labels.put(3.0, "d");
        labels.put(4.15, "c");
        labels.put(8.15, "b");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
