package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        //String fileName1 = "d:/1.txt";
        //String fileName2 = "d:/2.txt";
        FileInputStream fileInput1 = new FileInputStream(fileName1);

        byte[] buffer = new byte[fileInput1.available()];
        while (fileInput1.available() > 0) {
           fileInput1.read(buffer);
        }
        FileInputStream fileInput2 = new FileInputStream(fileName2);
        FileOutputStream fileOutput = new FileOutputStream(fileName1);

        while (fileInput2.available() > 0) {
            fileOutput.write(fileInput2.read());
        }
        fileOutput.write(buffer);
        fileInput1.close();
        fileInput2.close();
        fileOutput.close();
    }
}
