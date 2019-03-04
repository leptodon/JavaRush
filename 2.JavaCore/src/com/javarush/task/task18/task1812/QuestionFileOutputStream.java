package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    protected AmigoOutputStream fileOutputStream;
    public QuestionFileOutputStream(AmigoOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
  }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Thread thread = new Thread();
        System.out.print("Вы действительно хотите закрыть поток? Д/Н");
        if (reader.readLine().equals("Д")) {
            fileOutputStream.close();
            thread.interrupt();
        }
    }
}

