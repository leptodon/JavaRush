package com.javarush.task.test;

public class arrayReplace {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 1};
        arrayReplace(arr1,  1, 3);

    }

    static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        int arr[] = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                arr[i]=substitutionElem;
            } else {
                arr[i]=inputArray[i];
            }
        }
        return arr;
    }
}
