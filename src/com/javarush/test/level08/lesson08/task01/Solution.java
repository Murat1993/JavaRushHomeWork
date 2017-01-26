package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<>();
        set.add("Лиса");
        set.add("Лес");
        set.add("Лось");
        set.add("Лень");
        set.add("Ливень");
        set.add("Лошадь");
        set.add("Лодка");
        set.add("Листок");
        set.add("Лесной");
        set.add("Лампока");
        set.add("Летчик");
        set.add("Лак");
        set.add("Лифт");
        set.add("Ложка");
        set.add("Лямка");
        set.add("Лодрь");
        set.add("Лаз");
        set.add("Лондон");
        set.add("Любовь");
        set.add("Лужа");

        return set;
    }
}
