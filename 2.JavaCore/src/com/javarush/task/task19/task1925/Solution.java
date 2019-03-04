package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(args[1]))){
                String outputString = "";
                while (inputFile.ready()) {
                    String[] arr = inputFile.readLine().split("\\s");
                    for (String x : arr) {
                        if (x.length() > 6) {
                            outputString += x + ",";
                        }
                    }
                }
                outputFile.write(outputString.substring(0,outputString.length()-1));
            }
        } catch (Exception e) {

        }
    }
}
