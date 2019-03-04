package com.javarush.task.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class variableName {
    public static void main(String[] args) {
        String name = "qq_q";

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*$");
        Pattern pat = Pattern.compile("^[0-9]");
        Matcher matcher = pattern.matcher(name);
        Matcher matcher0 = pat.matcher(name.charAt(0)+"");
        if(!matcher0.find()){
            if (matcher.find()){
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        } else {
            System.out.println("NUMBER");
        }

    }
}
