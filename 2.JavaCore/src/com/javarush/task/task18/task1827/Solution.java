package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            FileWriter fw = new FileWriter(fileName, true);
            TreeSet<Integer> list = new TreeSet<>();
            String line = "";
            String str = "";
            String finalStr = "";
            while (br.ready()) {
                line = br.readLine();
                for (int i = 0; i < line.length(); i++) {
                    try {
                        str += Integer.parseInt(line.charAt(i) + "");
                    } catch (Exception e) {
                        list.add(Integer.parseInt(str));
                        str = "";
                        line = "";
                        break;
                    }
                }
            }
            String tmp = (list.last() + 1) + "";

            if (tmp.length() < 8) {
                while (tmp.length() < 8) {
                    tmp += " ";
                }
                finalStr += tmp;
                tmp = "";
            } else {
                finalStr += tmp;
                tmp = "";
            }

            if (args[1].length() > 30) {
                tmp = args[1].substring(0, 30);
                finalStr += tmp;
                tmp = "";
            } else {
                tmp = args[1];
                while (tmp.length() < 30) {
                    tmp += " ";
                }
                finalStr += tmp;
                tmp = "";
            }

            if (args[2].length() > 8) {
                tmp = args[2].substring(0, 8);
                finalStr += tmp;
                tmp = "";
            } else {
                tmp = args[2];
                while (tmp.length() < 8) {
                    tmp += " ";
                }
                finalStr += tmp;
                tmp = "";
            }

            if (args[3].length() > 4) {
                tmp = args[3].substring(0, 4);
                finalStr += tmp;
                tmp = "";
            } else {
                tmp = args[3];
                while (tmp.length() < 4) {
                    tmp += " ";
                }
                finalStr += tmp;
                tmp = "";
            }

            System.out.println(finalStr.length());
            fw.write("\r\n" + finalStr);
            br.close();
            fw.close();
        } catch (Exception e) {

        }

    }
}