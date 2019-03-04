package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    public static void main(String[] args) throws IOException {
/*        FileConsoleWriter file = new FileConsoleWriter(new FileWriter("d:/1.txt"));
        file.write("dasdasdasd\nasdads");
        file.close();*/
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }
    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf,off,len);
        for (int i = 0; i < cbuf.length; i++) {
            if (i >= off && i<off+len) {
                System.out.print(cbuf[i]);
            }
        }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char x : cbuf) {
            System.out.print(x);
        }
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
