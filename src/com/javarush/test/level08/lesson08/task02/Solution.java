package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iter = set.iterator();

        while (iter.hasNext()) {
            Integer i = iter.next();

            if (i > 10) {
                iter.remove();
            }
        }

        return set;
    }

    public static void main(String[] args) {

        HashSet<Integer> set = createSet();
        System.out.println(set);
        removeAllNumbersMoreThan10(set);
        System.out.println(set);
    }
}
