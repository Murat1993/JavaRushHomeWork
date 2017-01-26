package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException
    {
        super(fileName);
        if (fileName.endsWith(".txt")) {

        } else {
            throw new UnsupportedFileNameException();
        }
    }

    public int read() throws IOException
    {
        return super.read();
    }

    public void close() throws IOException
    {
        super.close();
    }

    @Override
    public int available() throws IOException
    {
        return super.available();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException
    {
        return super.read(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return super.getChannel();
    }

    @Override
    public int read(byte[] b) throws IOException
    {
        return super.read(b);
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    @Override
    public synchronized void mark(int readlimit)
    {
        super.mark(readlimit);
    }

    @Override
    public long skip(long n) throws IOException
    {
        return super.skip(n);
    }
}

