package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
        super.write(System.lineSeparator());
        super.flush();
        System.out.print(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
        super.write(System.lineSeparator());
        super.flush();
        for (int i = off; i < len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
        super.flush();
        char[] chars = str.toCharArray();
        for (int i = off; i < len; i++) {
            System.out.print(chars[i]);
        }
    }

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("myfile.txt");
        fileConsoleWriter.write("something");
        fileConsoleWriter.write(222);
        fileConsoleWriter.write("safsdf".toCharArray());
        fileConsoleWriter.write("");
    }
}
