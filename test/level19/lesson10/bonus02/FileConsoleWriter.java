package com.javarush.test.level19.lesson10.bonus02;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(String file) throws IOException
    {
        super(file);
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.print((char) c);
        super.write(c);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.print(str.substring(off, off + len));
        super.write(str, off, len);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        System.out.print(String.valueOf(cbuf).substring(off, off + len));
        super.write(cbuf, off, len);
    }
}