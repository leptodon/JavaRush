package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        byte[] buff = new byte[1000];

        while (inputStream.available() > 0) {
            int count = inputStream.read(buff);
            for (int i = buff.length-1; i >= 0; i--) {
                if (buff[i] != 0) {
                    outputStream.write(buff[i]);
                }
            }
        }

        inputStream.close();
        outputStream.close();
        System.out.println("finish");

    }
}
