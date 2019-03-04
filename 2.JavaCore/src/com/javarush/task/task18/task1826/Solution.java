package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int key = 22;
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data+key);
            }
        } else if (args[0].equals("-d")) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data-key);
            }
        } else {
            System.out.println("Введены не верные параметры");
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
