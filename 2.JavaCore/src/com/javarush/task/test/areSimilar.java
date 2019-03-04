package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class areSimilar {
    public static void main(String[] args) {
        boolean isSimilar = true;
        int[] a = {832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
        int[] b = {832, 570, 148, 998, 533, 561, 455, 147, 894, 279};
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if((a[i]!=b[i])){
                listA.add(a[i]);
                listB.add(b[i]);
                count++;
            }
        }
        Collections.sort(listA);
        Collections.sort(listB);

        if (!(listA.equals(listB)&&count<=2)) {
            isSimilar = false;
        }
        System.out.println(isSimilar + " " + count);
    }
}
