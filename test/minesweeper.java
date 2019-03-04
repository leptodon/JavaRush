package com.javarush.task.test;

public class minesweeper {
    public static void main(String[] args) {
        boolean[][] matrix = {{true, false, false}, {false, true, false}, {false, false, false}};
        minesweeper(matrix);
    }

    public static int[][] minesweeper(boolean[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (x == 0) {
                    if (y == 0) { // Если строка и столбец = 0
                        if (matrix[x][(y + 1)]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y + 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y]) {
                            arr[x][y]++;
                        }
                    } else if (y == matrix[0].length - 1) { // Если строка = 0, а столбец последний
                        if (matrix[x][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y]) {
                            arr[x][y]++;
                        }
                    } else { //Если в середине первой строки
                        if (matrix[x][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y + 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y + 1]) {
                            arr[x][y]++;
                        }
                    }
                } else if (x == matrix.length - 1) {
                    if (y == 0) {
                        if (matrix[x-1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y+1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y+1]) {
                            arr[x][y]++;
                        }
                    } else if (y == matrix[0].length - 1) {
                        if (matrix[x-1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y-1]) {
                            arr[x][y]++;
                        }
                    } else {
                        if (matrix[x][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y+1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y+1]) {
                            arr[x][y]++;
                        }
                    }
                } else { //Если не первая и не последние строки
                    if (y == 0) {
                        if (matrix[x - 1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x - 1][y + 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y + 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y + 1]) {
                            arr[x][y]++;
                        }

                        if (matrix[x + 1][y]) {
                            arr[x][y]++;
                        }
                    } else if (y == matrix[0].length - 1) {
                        if (matrix[x - 1][y]) {
                            arr[x][y]++;
                        }

                        if (matrix[x - 1][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y - 1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x + 1][y]) {
                            arr[x][y]++;
                        }

                    } else {
                        if (matrix[x - 1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x - 1][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x+1][y-1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x+1][y]) {
                            arr[x][y]++;
                        }
                        if (matrix[x+1][y+1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x][y+1]) {
                            arr[x][y]++;
                        }
                        if (matrix[x-1][y+1]) {
                            arr[x][y]++;
                        }
                    }
                }
            }
        }
        return arr;
    }
}
