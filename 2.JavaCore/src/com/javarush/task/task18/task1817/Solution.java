package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        double space = 0;
        double nonSpace = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == 32) {
                space++;
            }else {
                nonSpace++;
            }
        }
        inputStream.close();
        double ratio = (space/(nonSpace+space))*100;
        System.out.printf("%.2f", ratio);
    }
}
