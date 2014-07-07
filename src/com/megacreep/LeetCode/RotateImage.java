package com.megacreep.LeetCode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int temp = 0;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; 
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
    public static void main(String[] ars) {
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new RotateImage().rotate(matrix);
        Utils.printMatrix(matrix);
    }
}
