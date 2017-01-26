package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String mode = args[0];

        if (mode.equals("-c")) {
            String birthDate = args[args.length - 1];
            String sex = args[args.length - 2];

            StringBuilder name = new StringBuilder();
            for (int i = 1; i < args.length - 2; i++) {
                name.append(args[i]).append(" ");
            }
            String fullName = name.deleteCharAt(name.length() - 1).toString();


            String pattern = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Date date = new Date();
            try
            {
                date = format.parse(birthDate);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            if (sex.equals("м")) {
                Person person = Person.createMale(fullName, date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }

            if (sex.equals("ж")) {
                Person person = Person.createFemale(fullName, date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }

            System.out.println(date);
        }

        if (mode.equals("-u")) {
            int id = Integer.parseInt(args[1]);

            String birthDate = args[args.length - 1];
            String sex = args[args.length - 2];

            StringBuilder name = new StringBuilder();
            for (int i = 2; i < args.length - 2; i++) {
                name.append(args[i]).append(" ");
            }
            String fullName = name.deleteCharAt(name.length() - 1).toString();

            Person person = allPeople.get(id);
            person.setName(fullName);

            if (sex.equals("м")) {
                person.setSex(Sex.MALE);
            }

            if (sex.equals("ж")) {
                person.setSex(Sex.FEMALE);
            }

            String pattern = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Date date = new Date();
            try
            {
                date = format.parse(birthDate);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            person.setBirthDay(date);

        }


        if (mode.equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDay(null);
            person.setSex(null);
            person.setName(null);
        }



        if (mode.equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            Date date = person.getBirthDay();
            String pattern = "dd-MMM-yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Sex sex = person.getSex();
            String sexOut = null;
            if (sex.equals(Sex.MALE)) {
                sexOut = "м";
            }

            if (sex.equals(Sex.FEMALE)) {
                sexOut = "ж";
            }
            System.out.println(args[1] + ": " + person.getName() + " " + sexOut + " " + format.format(date) );
        }
    }
}
