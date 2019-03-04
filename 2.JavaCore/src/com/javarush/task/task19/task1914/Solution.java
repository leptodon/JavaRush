package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] arr = result.split("\\D+", 3);
        String tmp = result.replaceAll("[\\d\\s=\\\\rn]+", "");
        switch (tmp) {
            case "+":
                System.out.println(Integer.parseInt(arr[0]) + " + " + Integer.parseInt(arr[1])+" = "+(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])));
                break;
            case "-":
                System.out.println(Integer.parseInt(arr[0]) + " - " + Integer.parseInt(arr[1])+" = "+(Integer.parseInt(arr[0]) - Integer.parseInt(arr[1])));
                break;
            case "*":
                System.out.println(Integer.parseInt(arr[0]) + " * " + Integer.parseInt(arr[1])+" = "+(Integer.parseInt(arr[0]) * Integer.parseInt(arr[1])));
                break;
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

