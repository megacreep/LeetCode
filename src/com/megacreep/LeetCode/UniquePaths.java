package com.megacreep.LeetCode;

public class UniquePaths {

    public int uniquePathsRecursive(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
    }

    public int uniquePaths(int m, int n) {
    	return combine(m + n - 2, n - 1);
    }
    
    private int combine(int m, int n) {
    	if (m == 0 || n == 0) {
    		return 1;
    	}
    	if (m - n < n) {
    		n = m - n;
    	}
    	int multi = 1;
    	int divider = 1;
    	int gcd;
    	int result = 1;
    	for (int i = 0; i < n; i++) {
    		multi *= m - i;
    		divider *= 1 + i;
    		gcd = calGcd(multi, divider);
    		multi /= gcd;
    		divider /= gcd;
    		result *= multi;
    		result /= divider;
    	}

    	return result;
    }
    private int calGcd(int a, int b) {
    	while (b != 0) {
    		int c = a % b;
    		a = b;
    		b = c;
    	}
    	return a;
    }

    public int uniquePathsDP(int m, int n) {
    	if (m == 1 || n == 1) {
    		return 1;
    	}
    	int[] map = new int[n + 1];
    	for (int i = 1; i <= n; i++) {
    		map[i] = 1;
    	}
    	for (int i = 2; i <= m; i++) {
    		for (int j = 2; j <= n; j++) {
    			map[j] += map[j - 1];
    		}
    	}
    	return map[n];
    }
    
	public int uniquePathsMime(int m, int n) {
		int[][] result = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			result[i][1] = 1;
		}
		for (int i = 0; i <= n; i++) {
			result[1][i] = 1;
		}
		
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		
		return result[m][n];
	}
	
	public static void main(String[] args) {
		UniquePaths solver = new UniquePaths();
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.println("Testing: " + i + " " + j + " result: " + solver.uniquePaths(i, j));
			}
		}
	}
}
