package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());

/*        FileInputStream file1 = new FileInputStream("d:/1.txt");
        FileOutputStream file2 = new FileOutputStream("d:/2.txt");
        FileOutputStream file3 = new FileOutputStream("d:/3.txt");*/

        System.out.println(file1.available());
        int val = file1.available();
        int count = 0;
        while (file1.available() > 0) {
            int read = file1.read();
            if (val % 2 == 0) {
                if (count >= 0 && count < val / 2) {
                    file2.write(read);
                    count++;
                } else {
                    file3.write(read);
                    count++;
                }
            } else {
                if (count >= 0 && count <= val / 2) {
                    file2.write(read);
                    count++;
                } else {
                    file3.write(read);
                    count++;
                }
            }
        }

        file1.close();
        file2.close();
        file3.close();
    }
}
