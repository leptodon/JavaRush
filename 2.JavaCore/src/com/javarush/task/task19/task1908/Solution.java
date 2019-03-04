package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile= reader.readLine();
        //String inputFile = "d:/1.txt";
        //String outputFile = "d:/2.txt";
        BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));
        String line;
        Pattern pattern = Pattern.compile("\\d+");
        String[] arr;
        while ((line=fileReader.readLine())!=null) {
            arr = line.split("\\s", line.length());
            for (String x : arr) {
                Matcher matcher = pattern.matcher(x);
                if (matcher.matches()) {
                fileWriter.write(x + " ");
                }
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
