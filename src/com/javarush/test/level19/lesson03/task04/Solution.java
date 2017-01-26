package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            if (scanner.hasNext())
            {
                String[] personData = scanner.nextLine().split(" ");

                Date birthDate = new GregorianCalendar(
                        Integer.parseInt(personData[5]),
                        Integer.parseInt(personData[4]) - 1,
                        Integer.parseInt(personData[3])).getTime();

                return new Person(personData[1], personData[2], personData[0], birthDate);
            } else {
                return null;
            }
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
