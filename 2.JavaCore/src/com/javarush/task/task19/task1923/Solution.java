package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(args[1]))) {
                String getString = "";
                while (inputFile.ready()) {
                    String[] arr = inputFile.readLine().split("\\s");
                    for (String x : arr) {
                        Matcher m = Pattern.compile("\\d+").matcher(x);
                        if (m.find()) {
                            getString += x+" ";
                        }
                    }
                }
                outputFile.write(getString.substring(0, getString.length()-1));
            }
        } catch (Exception e) {
        }
    }
}
