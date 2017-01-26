package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем
(количество элементов в списке). Это же число метод должен выводить на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static int getStackTraceDeep()
    {
        //напишите тут ваш код
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            String methodName= elements[i].getMethodName();
            arrayList.add(i, methodName);
        }
        int someInt = arrayList.size();
        System.out.println(someInt);
        return someInt;

    }
}
