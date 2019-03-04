package com.javarush.task.test;

import java.util.ArrayList;

public class almostIncreasingSequence {
    public boolean almostIncreasingSequence(int[] sequence) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : sequence) {
            list.add(x);
        }
        int count = 0;
        boolean up = false;
        int tmp = 0;
        boolean isFound = false;
        for (int i = 0; i < sequence.length - 1; i++) {
            if ((sequence[i] < sequence[i + 1]) && i > 0) {
            } else {
                tmp = i;
            }
        }

        list.remove(tmp);
        if (list.size() == 1) {
            up = true;
        } else {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) < list.get(j + 1)) {
                    up = true;
                } else {
                    list.add(tmp, sequence[tmp]);
                    list.remove(tmp + 1);
                    for (int c = 0; c < list.size() - 1; c++) {
                        if (list.get(c) < list.get(c + 1)) {
                            up = true;
                        } else {
                            up = false;
                            break;
                        }

                    }
                    break;
                }
            }
        }
        return up;
    }
}