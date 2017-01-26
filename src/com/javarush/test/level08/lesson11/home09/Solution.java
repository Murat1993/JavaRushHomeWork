package com.javarush.test.level08.lesson11.home09;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("MAY 1 2013");  // true
    }

    public static boolean isDateOdd(String date)
    {
        long date1 = Date.parse(date);

        Date date2 = new Date(date1);
        int month = date2.getMonth();
        int day = date2.getDate();
        int year = date2.getYear();



        Map<String, Integer> months = new HashMap<>();
        months.put("JANUARY", 31);
        if (year % 4 == 0)
        {
            months.put("FEBRUARY", 29);
        }
        else {
            months.put("FEBRUARY", 28);
        }
        months.put("MARCH", 31);
        months.put("APRIL", 30);
        months.put("MAY", 31);
        months.put("JUNE", 30);
        months.put("JULY", 31);
        months.put("AUGUST", 31);
        months.put("SEPTEMBER", 30);
        months.put("OCTOBER", 31);
        months.put("NOVEMBER", 30);
        months.put("DECEMBER", 31);


        Map<Integer, String> monthsToNumber = new HashMap<>();
        monthsToNumber.put(0, "JANUARY");
        monthsToNumber.put(1, "FEBRUARY");
        monthsToNumber.put(2, "MARCH");
        monthsToNumber.put(3, "APRIL");
        monthsToNumber.put(4, "MAY");
        monthsToNumber.put(5, "JUNE");
        monthsToNumber.put(6, "JULY");
        monthsToNumber.put(7, "AUGUST");
        monthsToNumber.put(8, "SEPTEMBER");
        monthsToNumber.put(9, "OCTOBER");
        monthsToNumber.put(10, "NOVEMBER");
        monthsToNumber.put(11, "DECEMBER");

        int sumOfDays = 0;

        if (month == 0)
        {
            sumOfDays += day;
        }
        else
        {
            for (int i = 0; i < month; i++)
            {
                String monthKey = monthsToNumber.get(i);
                sumOfDays += months.get(monthKey);
            }
            sumOfDays += day;
        }


        if (sumOfDays % 2 == 0) {
            return false;
        } else {
            return true;
        }



    }
}
