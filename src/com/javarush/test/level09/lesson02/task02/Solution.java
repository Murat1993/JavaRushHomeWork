package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода,
вызвавшего его, полученное с помощью StackTrace.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<String> methodNames = new ArrayList<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String name = stackTraceElements[i].getMethodName();
            methodNames.add(i, name);
        }
        return methodNames.get(2);
    }

    public static String method2()
    {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<String> methodNames = new ArrayList<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String name = stackTraceElements[i].getMethodName();
            methodNames.add(i, name);
        }
        return methodNames.get(2);
    }

    public static String method3()
    {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<String> methodNames = new ArrayList<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String name = stackTraceElements[i].getMethodName();
            methodNames.add(i, name);
        }
        return methodNames.get(2);
    }

    public static String method4()
    {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<String> methodNames = new ArrayList<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String name = stackTraceElements[i].getMethodName();
            methodNames.add(i, name);
        }
        return methodNames.get(2);

    }

    public static String method5()
    {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<String> methodNames = new ArrayList<>();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String name = stackTraceElements[i].getMethodName();
            methodNames.add(i, name);
        }
        return methodNames.get(2);
    }
}
