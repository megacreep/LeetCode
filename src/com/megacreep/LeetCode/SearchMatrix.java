package com.megacreep.LeetCode;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m <= 0) {
			return false;
		}
		int n = matrix[0].length;
		if (n <= 0) {
			return false;
		}
		int start = 0, end = m * n - 1;
		int middle;
		while (start <= end) {
			middle = (start + end) / 2;
			int num = getNum(matrix, middle, m, n);
			if (num == target) {
				return true;
			} else if (num < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return false;
	}
	private int getNum(int[][] matrix, int seq, int m, int n) {
		return matrix[seq / n][seq % n];
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
		};

		System.out.println(new SearchMatrix().searchMatrix(matrix, 3));
	}
}
