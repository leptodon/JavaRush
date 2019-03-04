package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

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
        while ((line=fileReader.readLine())!=null) {
            fileWriter.write(line.replaceAll("\\p{Punct}", ""));
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
