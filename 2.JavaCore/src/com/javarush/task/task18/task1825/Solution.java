package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeMap;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        String input = "";
        String clearFileName = "";
        String filename = "";

        while (!(input = reader.readLine()).equals("end")) {
            for (int i = 0; i < input.length(); i++) {
                String number = "";
                String part = input.charAt(i) + "" + input.charAt(i + 1) + "" + input.charAt(i + 2) + "" + input.charAt(i + 3) + "";
                if (part.equals("part")) {
                    number = input.substring(i + 4, input.length());
                    clearFileName = input.substring(0, i - 1);
                    map.put(Integer.parseInt(number), input);
                    break;
                }
            }
        }
        FileWriter fw = new FileWriter(clearFileName,true);

        for (int j = 1; j <= map.size(); j++) {
            filename = map.get(j);
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine())!=null) {
                fw.write(line);
            }
            br.close();
        }
        fw.close();
        reader.close();
    }
}
