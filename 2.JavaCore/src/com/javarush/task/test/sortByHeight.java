package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Collections;

public class sortByHeight {
    public static void main(String[] args) {
        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int x = 0; x<a.length; x++) {
            if (a[x] != -1) {
                list.add(a[x]);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                a[i] = list.get(count);
                count++;
            }
        }
    }
}
