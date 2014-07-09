package com.megacreep.LeetCode;

public class SetZeroes {
	public void setZeroes(int[][] matrix) {
		
	}

	public void setZeroesMime(int[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRowZero = false;
		for (int i = 0; i < n && !firstRowZero; i++) {
			firstRowZero = matrix[0][i] == 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = m - 1; i > 0; i--) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = n - 1; j > 0; j--) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (matrix[0][0] == 0) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{1,1,1,1},
				{0,1,1,1},
				{1,1,1,1}
		};

		new SetZeroes().setZeroes(matrix);
		Utils.printMatrix(matrix);
	}
}
