package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "d:/1.txt";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher;
        String line;
        int count = 0;
        while ((line = fileReader.readLine()) != null) {
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileReader.close();
    }
}
