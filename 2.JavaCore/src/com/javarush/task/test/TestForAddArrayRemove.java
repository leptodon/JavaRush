package com.javarush.task.test;

import java.util.Arrays;
import java.util.Collections;

public class TestForAddArrayRemove {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
        }
        long b = System.currentTimeMillis();
        System.out.println((b-a)+"ms");
    }
}
