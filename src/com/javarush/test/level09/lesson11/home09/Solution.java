package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();

        map.put("cat1", new Cat("Cat1"));
        map.put("cat2", new Cat("Cat2"));
        map.put("cat3", new Cat("Cat3"));
        map.put("cat4", new Cat("Cat4"));
        map.put("cat5", new Cat("Cat5"));
        map.put("cat6", new Cat("Cat6"));
        map.put("cat7", new Cat("Cat7"));
        map.put("cat8", new Cat("Cat8"));
        map.put("cat9", new Cat("Cat9"));
        map.put("cat10", new Cat("Cat10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> cats = new HashSet<>();

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            Cat name = pair.getValue();
            cats.add(name);
        }

        return cats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
