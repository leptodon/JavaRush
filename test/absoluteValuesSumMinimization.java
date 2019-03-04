package com.javarush.task.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class absoluteValuesSumMinimization {
    public static void main(String[] args) {
        long q = System.currentTimeMillis();
        int[] a = {-10, 100, 200, 300, 400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};

        int c = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++) {
            if (c == 0) {
                c=add(a[i],a);
                d=a[i];
            } else if (add(a[i],a) < c && a[i]!=a[i-1]) {
                c=add(a[i],a);
                d=a[i];
            }
        }
        long w = System.currentTimeMillis();
        System.out.println(d + " | time = " + (w-q));
    }
    public static int add(int x, int[] a){
        int minTmp = 0;
        for (int i = 0; i < a.length; i++) {
            minTmp += Math.abs(a[i]-x);
        }
        return minTmp;
    }
}
