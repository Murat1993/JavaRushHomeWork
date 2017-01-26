package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String file = reader.readLine();
            reader.close();

            if (args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);

                // productName
                StringBuilder productName = new StringBuilder();
                for (int i = 2; i < args.length - 2; i++) {
                    productName.append(args[i]).append(" ");
                }
                productName = productName.deleteCharAt(productName.length() - 1);
                char[] chars = productName.toString().toCharArray();
                StringBuilder finProductName = new StringBuilder();
                for (int i = 0; i < 30; i++) {
                    if (i > chars.length - 1) {
                        finProductName.append(" ");
                    } else
                    {
                        finProductName.append(chars[i]);
                    }
                }


                // quantity
                int quantity = Integer.parseInt(args[args.length - 1]);
                int finalQuantity;
                if (quantity > 9999) {
                    finalQuantity = 9999;
                } else {
                    finalQuantity = quantity;
                }


                // price
                String stringPrice = args[args.length - 2];
                double doublePrice = Double.parseDouble(stringPrice);
                String finalPrice = String.format(Locale.ENGLISH, "%-8.2f", doublePrice);


                String stringToUpdate = String.format("%-8d%s%s%-4d", id, finProductName, finalPrice, finalQuantity);

                // System.out.println(stringToUpdate);

                List<String> updatedStrings = new ArrayList<>();
                BufferedReader fileReaderForId = new BufferedReader(new FileReader(file));
                while (fileReaderForId.ready()) {
                    String string = fileReaderForId.readLine();
                    if (string.equals("")) {
                        continue;
                    }
                    char[] charArray = string.toCharArray();
                    String number = "";
                    for (int i = 0; i < 8; i++) {
                        if (charArray[i] == ' ') {
                            continue;
                        }
                        number += charArray[i];
                    }

                    if (Integer.parseInt(number) == id) {
                        updatedStrings.add(stringToUpdate);
                    } else {
                        updatedStrings.add(string);
                    }

                }
                fileReaderForId.close();





                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                for (String string : updatedStrings) {
                    writer.write(string);
                    writer.write(System.lineSeparator());
                    writer.flush();
                }
                writer.close();

            }



            if (args[0].equals("-d")) {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                List<String> deletedList = new ArrayList<>();
                while (fileReader.ready()) {
                    String string = fileReader.readLine();
                    if (string.equals("")) {
                        continue;
                    }
                    char[] chars = string.toCharArray();
                    String number = "";
                    for (int i = 0; i < 8; i++) {
                        if (chars[i] == ' ') {
                            continue;
                        }
                        number += chars[i];
                    }

                    if (number.equals(args[1])) {
                        continue;
                    }
                    deletedList.add(string);
                }
                fileReader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < deletedList.size(); i++) {
                    writer.write(deletedList.get(i));
                    if (i != deletedList.size() - 1) {
                        writer.write(System.lineSeparator());
                        writer.flush();
                    }
                    writer.flush();
                }
                writer.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
