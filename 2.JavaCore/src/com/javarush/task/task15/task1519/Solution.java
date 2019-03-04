package com.javarush.task.task15.task1519;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            if (!input.equals("exit")) {
                try {
                    if (input.contains(".")) print(Double.parseDouble(input));
                    else if((Long.parseLong(input) <= 0) || (Long.parseLong(input) >= 128)) print(Integer.parseInt(input));
                    else if ((Short.parseShort(input) > 0) && (Short.parseShort(input) < 128)) print(Short.parseShort(input));
                } catch (NumberFormatException e) {
                    print(input);
                }
            } else {
                break;
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
