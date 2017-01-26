package com.javarush.test.level14.lesson08.bonus03;


public class Singleton
{
    private static Singleton singleton;

    public static Singleton getInstance() {
        if (Singleton.singleton == null) {
            Singleton.singleton = new Singleton();
            return Singleton.singleton;
        } else
        return Singleton.singleton;
    }


    private Singleton() {

    }
}
