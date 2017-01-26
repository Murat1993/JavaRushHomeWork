package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;

        MyWrapper myStream = new MyWrapper(System.out);
        System.setOut(myStream);

        testString.printSomething();

        System.setOut(defaultStream);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyWrapper extends PrintStream {

        private PrintStream out;
        private int i = 0;

        public MyWrapper(PrintStream out)
        {
            super(out);
            this.out = out;
        }

        @Override
        public void println(String string) {
            if (i == 0)
            {
                out.println(string);
            }
            else if (i % 2 == 0) {
                out.println("JavaRush - курсы Java онлайн");
                out.println(string);
            } else {
                out.println(string);
            }
            i++;
        }
    }
}
