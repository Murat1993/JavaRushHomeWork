package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String firstName;
        String secondName;
        int age;
        String job;
        String city;
        boolean sex;

        public Human() {

        }

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String firstName, String secondName, String job) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.job = job;
        }

        public Human(String firstName, String secondName, String job, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.job = job;
            this.age = age;
        }

        public Human(String firstName, String secondName, String job, int age , String city) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.job = job;
            this.age = age;
            this.city = city;
        }

        public Human(String firstName, String secondName, String job, int age , String city, boolean sex) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.job = job;
            this.age = age;
            this.city = city;
            this.sex = sex;
        }

        public Human(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }
    }
}
