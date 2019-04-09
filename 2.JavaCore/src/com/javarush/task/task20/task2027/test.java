package com.javarush.task.task20.task2027;

import java.io.StringReader;

public class test {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("uusameouusameouusameo");
        System.out.println(str.lastIndexOf("same"));
    }
}
