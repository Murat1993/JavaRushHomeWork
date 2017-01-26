package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

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
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        reader.close();
        StringBuilder productName = new StringBuilder();
        for (int i = 1; i < args.length - 2; i++) {
            productName.append(args[i]).append(" ");
        }

        productName = productName.deleteCharAt(productName.length() - 1);
        String stringPrice = args[args.length - 2];
        double doublePrice = Double.parseDouble(stringPrice);
        String finalPrice = String.format(Locale.ENGLISH, "%-8.2f", doublePrice);
        int quantity = Integer.parseInt(args[args.length - 1]);


        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        List<Integer> id = new ArrayList<>();
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
            if (!number.isEmpty()) {
                id.add(Integer.parseInt(number));
            }
        }

        int idAfterIncrement;
        boolean fileIsEmpty = false;
        if (!id.isEmpty())
        {
            int maxId = Collections.max(id);
            if (maxId == 99999999)
            {
                idAfterIncrement = 99999999;
            } else
            {
                idAfterIncrement = maxId + 1;
            }
        } else {
            fileIsEmpty = true;
            idAfterIncrement = 1;
        }

        int finalQuantity;
        if (quantity > 9999) {
            finalQuantity = 9999;
        } else {
            finalQuantity = quantity;
        }

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

        String stringToWrite = String.format("%-8d%s%s%-4d", idAfterIncrement, finProductName, finalPrice, finalQuantity);

        if (fileIsEmpty) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringToWrite);
            writer.flush();
            writer.close();
        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write('\n' + stringToWrite);
            writer.flush();
            writer.close();
        }


    }
}
