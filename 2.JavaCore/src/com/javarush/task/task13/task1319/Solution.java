package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter br = new BufferedWriter(new FileWriter(fileName));

        while (true){
            String data = reader.readLine();
            if (data.equals("exit")){
                br.write(data+"\r\n");
                break;
            } else {
                br.write(data+"\r\n");
            }
        }

        br.close();
        reader.close();
    }
}
