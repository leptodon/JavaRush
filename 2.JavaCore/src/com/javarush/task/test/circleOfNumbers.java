package com.javarush.task.test;

public class circleOfNumbers {
    public static void main(String[] args) {
        int n = 6;
        int firstNumber = 3;
        if (n / 2 + firstNumber >= n) {
            System.out.println(firstNumber-n/2);
        }else {
            System.out.println(n / 2 + firstNumber);
        }
        }
}
