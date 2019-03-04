package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            while (true) {
                input = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(input);
                fileInputStream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
    }
}
