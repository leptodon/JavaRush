package com.javarush.task.test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class isIPv4Address {
    public static void main(String[] args) {
        boolean isIPv4Address = false;

        String inputString = "a0.1.1.1";

        String[] arr = new String[4];

        /*            if (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 255) {
                isIPv4Address = true;
            } else{
                isIPv4Address = false;
                break;
            }*/
        ArrayList<String> qq = new ArrayList<>(Arrays.asList(inputString.split("\\.")));
        System.out.println(qq);
        for (String x: qq) {
            try {
                if (x.isEmpty() || qq.size()!=4) {
                    isIPv4Address = false;
                    break;
                } else if ((Integer.parseInt(x) >= 0 && Integer.parseInt(x) < 255)) {
                        isIPv4Address = true;
                } else {
                    isIPv4Address = false;
                    break;
                }
            } catch (Exception e) {
                isIPv4Address = false;
                break;
            }

        }
    }
}