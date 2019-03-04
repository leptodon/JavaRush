package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String splitInput = input.substring(input.indexOf('?') + 1, input.length());
        String[] tmpArr = splitInput.split("[&]");
        boolean isContain = splitInput.contains("obj");
        String sp = " ";
        String tmp = "";
        String tmp1 = "";

        if (!isContain) {
            for (int i = 0; i < tmpArr.length; i++) {
                if (tmpArr[i].contains("=") && i == 0) {
                    tmp1 = (tmpArr[i].substring(0, tmpArr[i].indexOf('=')));
                } else if (tmpArr[i].contains("=") && i > 0) {
                    tmp1 = String.join(sp, tmp1, tmpArr[i].substring(0, tmpArr[i].indexOf('=')));
                } else {
                    tmp1 = String.join(sp, tmp1, tmpArr[i]);
                }
            }
            System.out.println(tmp1);

        } else {
            for (int i = 0; i < tmpArr.length; i++) {
                if (tmpArr[i].contains("=") && i == 0) {
                    tmp = tmpArr[i].substring(0, tmpArr[i].indexOf('='));
                } else if (tmpArr[i].contains("=") && i > 0) {
                    tmp = String.join(sp, tmp, tmpArr[i].substring(0, tmpArr[i].indexOf('=')));
                } else {
                    tmp = String.join(sp, tmp, tmpArr[i]);
                }
            }
            System.out.println(tmp);
            try {
                alert(Double.parseDouble(tmpArr[0].substring(tmpArr[0].indexOf("=") + 1, tmpArr[0].length())));
            } catch (Exception e) {
                alert(tmpArr[0].substring(tmpArr[0].indexOf("=") + 1, tmpArr[0].length()));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
