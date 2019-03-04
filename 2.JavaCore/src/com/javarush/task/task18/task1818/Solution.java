package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file = new FileOutputStream(reader.readLine(), true);
        FileInputStream file1 = new FileInputStream(reader.readLine());
        BufferedInputStream buffFile1 = new BufferedInputStream(file1);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        BufferedInputStream buffFile2 = new BufferedInputStream(file2);

        while (buffFile1.available() > 0) {
            file.write(buffFile1.read());
        }
        while (buffFile2.available() > 0) {
            file.write(buffFile2.read());
        }

        file.close();
        file1.close();
        file2.close();
    }
}
