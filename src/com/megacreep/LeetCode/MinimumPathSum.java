package com.megacreep.LeetCode;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		if (grid.length <= 0) {
			return 0;
		}
		int m = grid.length;
		if (grid[0].length <= 0) {
			return 0;
		}
		int n = grid[0].length;
		int[] result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			result[i] = result[i - 1] + grid[0][i - 1]; 
		}
		result[0] = Integer.MAX_VALUE;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				result[j] = Math.min(result[j - 1], result[j]) + grid[i][j - 1];
			}
		}
		return result[n];
	}
	public static void main(String[] args) {
		int[][] grid = new int[][] {
				{1,2},
				{5,6},
				{1,1}
		};
		new MinimumPathSum().minPathSum(grid);
	}
}
