package com.javarush.task.test;

public class depositProfit {
    public static void main(String[] args) {
        int count = 0;
        int deposit  = 100;
        double newDep = deposit;
        int rate = 1;
        int threshold = 101;
        while (newDep < threshold) {
            newDep = (newDep*rate/100)+newDep;
            count++;
        }
        System.out.println(count);
    }

    public static void add(){

    }
}
