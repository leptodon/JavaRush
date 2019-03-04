package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Arrays;

public class reverseParentheses {
    public static void main(String[] args) {
        String inputString = "q(a(zswe)dcv(frbnhy(ujmki)o((lpzx)sedcvf)rymx)smkiol)p";
        long a = System.currentTimeMillis();
        ArrayList<String> str = new ArrayList<>(Arrays.asList(inputString.split("")));
        int first = 0;
        boolean isFoundFirst = false;
        boolean isFoundSecond = false;
        int second = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        result.append(inputString);
        while (result.toString().contains("(")) {
            for (int i = 0; i < str.size(); i++) {
                if (str.get(i).equals("(")) {
                    first = i;
                    isFoundFirst = true;
                } else if (str.get(i).equals(")")) {
                    second = i;
                    isFoundSecond = true;
                }
                if (isFoundFirst && isFoundSecond) {
                    tmp.append(result.substring(first + 1, second));
                    tmp.reverse();
                    result.delete(first, second + 1);
                    result.insert(first, tmp);
                    tmp.delete(0, 9999);
                    isFoundFirst = false;
                    isFoundSecond = false;
                    str.clear();
                    str = new ArrayList<>(Arrays.asList(result.toString().split("")));
                }
            }
            isFoundFirst = false;
            isFoundSecond = false;
        }
        long b = System.currentTimeMillis();
        System.out.println(result.toString() + " | time = " + (b-a) + "ms");
    }
}
