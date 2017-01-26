package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();

            BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));

            List<String> stringsFile1 = new ArrayList<>();
            List<String> stringsFile2 = new ArrayList<>();

            while (fileReader1.ready())
            {
                String string = fileReader1.readLine();
                if (!string.matches(""))
                {
                    stringsFile1.add(string);
                }

            }
            fileReader1.close();


            while (fileReader2.ready())
            {
                String string = fileReader2.readLine();
                if (!string.matches(""))
                {
                    stringsFile2.add(string);
                }
            }
            fileReader2.close();


            boolean previousWasSame = false;
            for (int i = 0, j = 0; i < stringsFile1.size(); i++)
            {
                // Если предыдущая пара была SAME
                if (previousWasSame)
                {
                    // Если строки не равны заходим сюда(они по определению должны быть не равны[условие задачи])
                    if (!stringsFile1.get(i).equals(stringsFile2.get(j)))
                    {
                        // Если это последняя строка во втором файле
                        if (stringsFile2.size() == j + 1)
                        {
                            if (stringsFile1.get(i + 1).equals(stringsFile2.get(j)))
                            {
                                lines.add(new LineItem(Type.REMOVED, stringsFile1.get(i)));
                                stringsFile1.remove(i);
                                i--;
                            }
                        }
                        // Если это последняя строка в первом файле
                        else if (stringsFile1.size() == i + 1)
                        {
                            if (stringsFile1.get(i).equals(stringsFile2.get(j + 1)))
                            {
                                lines.add(new LineItem(Type.ADDED, stringsFile2.get(j)));
                                lines.add(new LineItem(Type.SAME, stringsFile1.get(i)));
                                break;
                            }
                        } else
                        {
                            if (!stringsFile1.get(i).equals(stringsFile2.get(j + 1)))
                            {
                                lines.add(new LineItem(Type.REMOVED, stringsFile1.get(i)));
                                stringsFile1.remove(0);
                                i--;
                            } else if (stringsFile1.get(i).equals(stringsFile2.get(j + 1)))
                            {
                                lines.add(new LineItem(Type.ADDED, stringsFile2.get(j)));
                                i--;
                                j++;
                            }
                        }
                    }
                    previousWasSame = false;
                } else
                {
                    lines.add(new LineItem(Type.SAME, stringsFile1.get(i)));
                    stringsFile1.remove(0);
                    j++;
                    previousWasSame = true;

                    if (stringsFile2.size() == j)
                    {
                        lines.add(new LineItem(Type.REMOVED, stringsFile1.get(i)));
                        break;
                    }
                    i--;
                }
            }


            for (LineItem lineItem : lines)
            {
                System.out.println(lineItem.type + " " + lineItem.line);
            }


            fileReader1.close();
            fileReader2.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
