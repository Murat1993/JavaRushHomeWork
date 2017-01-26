package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров
(Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            //String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";  //reader.readLine();
            //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
            //String url = "javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&=&&?oobj=3.0&obj=&s.3";
            String url = reader.readLine();
            url =  url.replaceFirst("\\?", " ");
            String[] partWithArguments = url.split(" ");
            String[] arguments = partWithArguments[1].split("&");

            StringBuilder sb = new StringBuilder();
            List<Object> all = new ArrayList<>();
            for (String s : arguments)
            {
                if (s.matches("^obj=[\\p{all}]*")) {
                    if (s.matches("^obj=$")) {
                        sb.append(s.replaceAll("=", "")).append(" ");
                        continue;
                    }
                    String objArgument = s.split("=")[1];

                    if (objArgument.matches("[0-9]*[.][0-9]*") || objArgument.matches("[0-9]*")) {
                        sb.append("obj").append(" ");
                        all.add(Double.parseDouble(objArgument));
                    } else {
                        sb.append("obj").append(" ");
                        all.add(objArgument);
                    }
                    continue;
                }

                if (s.matches("="))
                {
                    sb.append(s).append(" ");
                }
                else {
                    sb.append(s.split("=")[0]).append(" ");
                }
            }

            System.out.println(sb.deleteCharAt(sb.length() - 1).toString().replaceAll("[ ]+", " "));

            for (Object object : all) {
                if (object instanceof Double) {
                    alert((Double) object);
                } else {
                    alert((String) object);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
