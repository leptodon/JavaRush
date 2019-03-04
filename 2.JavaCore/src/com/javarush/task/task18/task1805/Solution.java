package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        FileInputStream inputStream = new FileInputStream(input);

        //FileInputStream inputStream = new FileInputStream("d:/1.txt");

        Set<Integer> set = new TreeSet<Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            set.add(data);
        }
        inputStream.close();
        boolean isFirst = true;

        for (int x : set) {
            if (isFirst) {
                System.out.print(x);
                isFirst=false;
            } else {
                System.out.print(" "+x);
            }
        }
    }
}
