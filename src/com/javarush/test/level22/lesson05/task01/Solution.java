package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static String getPartOfString(String string)
    {


        return null;
    }

    public static class TooShortStringException extends RuntimeException
    {
    }

    public static void main(String[] args)
    {
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//        System.out.println(getPartOfString("На некорректные данные бросить исключение TooShortStringException (сделать исключением)."));
//        System.out.println(getPartOfString("Сигнатуру метода getPartOfString"));
//        System.out.println(getPartOfString(null));
//        System.out.println(getPartOfString("   g    "));
        System.out.println(getPartOfString("nfnf nfnf nfnf nfnf    "));
    }
}
