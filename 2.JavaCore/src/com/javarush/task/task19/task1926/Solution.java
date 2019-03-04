package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
                while (fileReader.ready()) {
                    StringBuilder str = new StringBuilder();
                    str.append(fileReader.readLine());
                    System.out.println(str.reverse().toString());
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
