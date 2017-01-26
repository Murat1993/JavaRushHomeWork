package com.javarush.test.level05.lesson12.home04;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

        Date date = new Date();
        //напишите тут ваш код
        System.out.println(dateFormat.format(date));
    }
}
