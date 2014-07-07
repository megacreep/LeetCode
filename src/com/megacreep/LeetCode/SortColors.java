package com.megacreep.LeetCode;

public class SortColors {
    public void sortColors(int[] A) {
        int i = -1, j = -1;
        for (int p = 0; p < A.length; p++) {
            int v = A[p];
            A[p] = 2;
            if (v == 0) {
                A[++j] = 1;
                A[++i] = 0;
            } else if (v == 1) {
                A[++j] = 1; 
            }
        }
    }
    public void sortColorsMime(int[] A) {
        int startOne = -1;
        int startTwo = A.length - 1;
        int i = 0;
        while (i <= startTwo) {
            if (A[i] == 1) {
                if (startOne == -1) {
                    startOne = i;
                }
                i++;
                continue;
            } else if (A[i] == 2) {
                swap(A, i, startTwo--);
            } else {
                if (startOne != -1) {
                    swap(A, i, startOne++); 
                }
                i++;
            }
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
