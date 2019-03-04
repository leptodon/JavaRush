package com.javarush.task.test;

public class arrayChange {
    public static void main(String[] args) {
        int[] inputArray = {2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15};
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < inputArray.length-1; i++) {
            if (inputArray[i] >= inputArray[i + 1]) {
                tmp = inputArray[i + 1];
                while (inputArray[i]>=tmp){
                    tmp++;
                    count++;
                }
                inputArray[i+1] = tmp;
            }
        }
        System.out.println(count);
    }
}
