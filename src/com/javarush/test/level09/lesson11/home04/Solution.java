package com.javarush.test.level09.lesson11.home04;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date utilDate;

        utilDate = formatter.parse(date);
        formatter.applyPattern("MMM dd, yyyy");
        String finDate = formatter.format(utilDate);
        char[] chars = finDate.toCharArray();
        for (int i = 0; i < 3; i++) {
            chars[i] = Character.toUpperCase(chars[i]);
        }
        finDate = new String(chars);


        System.out.println(finDate);


    }
}
