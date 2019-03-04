package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class avoidObstacles {
    public static void main(String[] args) {
        int[] inputArray = {1, 4, 10, 6, 2};
        Arrays.sort(inputArray);
        ArrayList<Integer> list = new ArrayList<>();
        int step = 1;
        int a = 0;
        for (int x : inputArray) {
            list.add(x);
        }
            while (a<(inputArray[inputArray.length-1])/step){
            step++;
                for (int i = 1; i <= (inputArray[inputArray.length-1])/step; i++) {
                    if (!list.contains(i * step)) {
                        a++;
                    } else {
                        a=0;
                       break;
                    }
                }
            }
        System.out.println(step);
    }
}