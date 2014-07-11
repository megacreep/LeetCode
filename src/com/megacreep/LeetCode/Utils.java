package com.megacreep.LeetCode;

import java.util.List;

public class Utils {

	public static void printArray(int[] array) {
		for(int num: array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

	public static void printArray(List<Integer> nums) {
		for (Integer num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

    public static void printList(List<List<Integer>> result) {
        for (List<Integer> list: result) {
            printArray(list);
        }
    }
}
