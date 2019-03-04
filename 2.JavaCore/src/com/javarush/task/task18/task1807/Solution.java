package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        FileInputStream inputStream = new FileInputStream(input);

        //FileInputStream inputStream = new FileInputStream("d:/1.txt");
        int count = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == ',') {
                count++;
            }
        }
        inputStream.close();

        System.out.println(count);
    }
}
