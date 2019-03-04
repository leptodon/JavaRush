package com.javarush.task.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExTest {
    public static void main(String[] args) {
        String sc = "ab1 abcd 2ab 123 1a2b3c";
        String pat = "(\\w+\\d+\\w+)";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(sc);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
