package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "d:/1.txt";
        List<String> fileContent = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

        if (args[0].equals("-u")) {
            String getLine;
            while (br.ready()) {
                getLine = br.readLine();
                if (getLine.substring(0, 8).trim().equals(args[1].trim())) {
                    fileContent.add(update(getLine.substring(0, 8), getLine.substring(8, 38), getLine.substring(38, 46), getLine.substring(46, 50), args));
                } else {
                    fileContent.add(getLine);
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (int i = 0; i < fileContent.size(); i++) {
                bw.write(fileContent.get(i)+"\r\n");
            }
            bw.close();
        }
        if (args[0].equals("-d")){
            String getLine;
            while (br.ready()) {
                getLine = br.readLine();
                if (!getLine.substring(0, 8).trim().equals(args[1].trim())) {
                    fileContent.add(getLine);
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (int i = 0; i < fileContent.size(); i++) {
                bw.write(fileContent.get(i)+"\r\n");
            }
            bw.close();
        }
        br.close();
    }

    public static String update(String id, String productName, String price, String quantity, String[] args) {
        StringBuilder newStr = new StringBuilder();
        int arrPos = 2;
        String pn = args[arrPos] + " ";
        newStr.append(id);
        if (args.length > 5) {
            pn = args[arrPos] + " ";
            boolean str = true;
            while (str) {
                arrPos++;
                try {
                    Float.parseFloat(args[arrPos]);
                    str = false;
                } catch (Exception e) {
                    pn += args[arrPos] + " ";
                }
            }
            pn = checkLength(pn, 30);
            newStr.append(pn);
        } else {
            pn = checkLength(pn, 30);
            newStr.append(pn);

        }
        arrPos++;
        newStr.append(checkLength(args[arrPos], 8));
        arrPos++;
        newStr.append(checkLength(args[arrPos], 4));
        return newStr.toString();
    }

    public static String checkLength(String str, int len) {
        String newStr = "";
        if (str.length() < len) {
            while (str.length() < len) {
                str += " ";
            }
            newStr = str;
        } else if (str.length() > len) {
            str = str.substring(0, len);
            newStr = str;
        } else {
            newStr = str;
        }
        return newStr;
    }

}
