package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

     static {
        labels.put(1.2, "qwe");
        labels.put(2.2, "asd");
        labels.put(3.2, "zxc");
        labels.put(4.2, "ert");
        labels.put(5.2, "dfg");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
