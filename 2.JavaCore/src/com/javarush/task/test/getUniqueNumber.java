package com.javarush.task.test;

import java.util.ArrayList;

public class getUniqueNumber {
    public static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        long N = 100000000;
        long a = System.currentTimeMillis();

        for (long r = 0; r < N; r++) {
            if (isNext(r)) {
                list.add(r);
            }
        }
        long b = System.currentTimeMillis();
        System.out.println((b - a) + "ms");
        System.out.println("memory: " + Runtime.getRuntime().totalMemory() / (1024 * 1024) + " mb");
        System.out.println("memory: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " mb");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(list.size());
    }

    public static boolean isNext(long number) {
        boolean isNext = false;
        try {
            long num = number; //Входящее число
            long digit;
            long digit2;
            while (num > 0) {
                digit = num % 10;
                digit2 = num / 10;
                if (digit >= digit2 % 10) {
                    isNext = true;
                } else {
                    isNext = false;
                    break;
                }
                num /= 10;
            }
        } catch (Exception e) {
            System.out.println("Ошибка в isNext");
        }

        return isNext;
    }

}