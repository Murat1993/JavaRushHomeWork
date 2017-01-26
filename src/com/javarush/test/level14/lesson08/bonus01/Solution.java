package com.javarush.test.level14.lesson08.bonus01;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.security.GeneralSecurityException;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CancellationException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new RuntimeException();
        } catch (Exception e ) {
            exceptions.add(e);
        }

        try
        {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            throw new CancellationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new BrokenBarrierException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            throw new GeneralSecurityException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new KeyException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            throw new InputMismatchException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
