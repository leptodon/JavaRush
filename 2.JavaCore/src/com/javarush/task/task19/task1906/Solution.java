package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputfile = reader.readLine();
        String outputFile = reader.readLine();
        FileReader fileReader = new FileReader(inputfile);
        FileWriter fileWriter = new FileWriter(outputFile);
        int i = 1;

        while (fileReader.ready()) {
            int data = fileReader.read();
            if (i % 2 == 0) {
                fileWriter.write(data);
                i++;
            } else {
                i++;
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}