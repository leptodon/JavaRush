package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            char ch = (char)data;
            if (alph.contains(ch+"")){
                count++;
            }
        }
        inputStream.close();
        System.out.println(count);
    }
}
