package com.javarush.task.test;

public class matrixElementsSum {
    int matrixElementsSum(int[][] matrix) {
        //стр//стол
        int sum = 0;
        int str = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i <= str - 1; i++) {
            for (int j = 0; j <= col - 1; j++) {
                if (i == 0) {
                    sum += matrix[i][j];
                } else if (matrix[i - 1][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;

    }

}
