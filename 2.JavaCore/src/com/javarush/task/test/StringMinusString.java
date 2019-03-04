package com.javarush.task.test;

public class StringMinusString {
    public static void main(String[] args) {
        String a = "<span xml:lang=\"en\" lang=\"en\">";
        String c = "";
        String b = a.replaceAll("(?<=<span).*?(?=>)", c);

        System.out.println(b);
    }
}
