package com.javarush.task.test;

import javafx.beans.binding.StringBinding;

import java.util.Arrays;
import java.util.Collections;

public class commonCharacterCount {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        String s3 = "";
        int count = 0;
        StringBuilder newStr = new StringBuilder(s2);
        s3 = newStr.toString();
        for (int i = 0; i < s1.length(); i++) {
            if(s3.contains(s1.charAt(i)+"")){
                count++;
                newStr.setCharAt(newStr.indexOf(String.valueOf(s1.charAt(i))), '0');
                s3 = newStr.toString();
            }
        }
        System.out.println(count);
        //return tmp.length();
    }
}
