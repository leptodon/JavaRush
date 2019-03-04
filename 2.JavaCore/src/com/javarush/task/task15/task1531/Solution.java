package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    private static String factorial(int n) {
        BigInteger a = BigInteger.valueOf(1);
        if(n<0){
            return BigInteger.valueOf(0).toString();
        }else if (n==0){
            return BigInteger.valueOf(1).toString();
        } else if (n <= 150) {
            for (int i = 1; i <= n; i++) {
                a = a.multiply(BigInteger.valueOf(i));
            }
            return a.toString();
       } else {
            return "";
        }
    }
}
