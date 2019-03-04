package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    //```java
    public static void main(String[] args) throws IOException {
/*
///Мое рабочее решение, но валидатор не принял

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        //String fileName1 = "d:/1.txt";
        //String fileName2 = "d:/2.txt";

        String str = "";
        int val = 0;

        FileInputStream fileInput = new FileInputStream(fileName1);
        FileOutputStream fileOutput = new FileOutputStream(fileName2);
        byte[] buffer = new byte[fileInput.available()];
        while (fileInput.available() > 0) {
            int byteRead = fileInput.read(buffer);
        }

        for (int i = 0; i < buffer.length; i++) {

            if (i == buffer.length - 1 || buffer[i] == 32) {
                val = Character.forDigit((int) Math.abs(Math.round(Double.parseDouble(str))), 10);
                if (i == buffer.length - 1) {
                    str += (char) buffer[i];
                    if (Double.parseDouble(str) >= 0) {
                        fileOutput.write(val);
                    } else {
                        fileOutput.write(45);
                        fileOutput.write(val);
                    }
                } else {
                    if (Double.parseDouble(str) >= 0) {
                        fileOutput.write(val);
                        fileOutput.write(32);
                    } else {
                        fileOutput.write(45);
                        fileOutput.write(val);
                        fileOutput.write(32);
                    }
                }

                str = "";
            } else if (buffer[i] != 32) {
                str += (char)buffer[i];
            }
        }
        fileInput.close();
        fileOutput.close();

*/
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String r = RD.readLine();//f2 test
        String t = RD.readLine();//f1 test2
        FileInputStream f2 = new FileInputStream(r);
        RD.close();
        PrintWriter pw = new PrintWriter(t);
        byte[] b = new byte[f2.available()];//test

        while (f2.available() > 0) {//test
            f2.read(b);
        }

        String s = new String(b, "US-ASCII");
        String[] d = s.split(" ");

        for (int i = 0; i < d.length; i++) {
            float a = Float.parseFloat(d[i]);
            int y = Math.round(a);
            pw.print(y + " ");
        }
        f2.close();
        pw.close();
    }
}