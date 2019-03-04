package com.javarush.task.test;

public class boxBlur {
    public static void main(String[] args) {
        int[][] image = {
                {36, 0, 18, 9},
                {27, 54, 9, 0},
                {81, 63, 72, 45}
        };
        int[][] arr;
        arr = new int[image.length - 2][image[0].length - 2];

        int tmp = 0;
        int str = 0;
        int col = 0;

        while (str < arr.length && col < arr[0].length) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    tmp += image[x + str][y + col];
                }
            }
            if (str < arr.length) {
                arr[str][col] = tmp / 9;
                tmp = 0;
                col++;
                if (col == arr[0].length) {
                    col = 0;
                    str++;
                    tmp = 0;
                }
            }
        }
        System.out.println(arr[str][col]);
    }
}
