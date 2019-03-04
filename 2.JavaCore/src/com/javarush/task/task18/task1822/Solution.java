package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "d:/1.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        String id = "";
        boolean isFound = false;
        while (!isFound) {
            line=br.readLine();
            for (int i = 0; i < line.length(); ) {
                if (line.charAt(i) != ' ') {
                    id += line.charAt(i);
                    i++;
                } else {
                    if (id.equals(args[0])) {
                        System.out.println(line);
                        isFound=true;
                        break;
                    }else {
                        id="";
                        break;
                    }
                }
            }
        }
        br.close();
    }
}
