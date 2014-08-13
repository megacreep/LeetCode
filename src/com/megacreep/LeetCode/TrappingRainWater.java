package com.megacreep.LeetCode;

public class TrappingRainWater {
    
    public int trap(int[] A) {
        int left = 0, right = A.length - 1;
        int all = 0, block = 0, currHeight = 0;
        while (left <= right) {
            int currMin = Math.min(A[left], A[right]);
            if (currMin > currHeight) {
                all += (currMin - currHeight) * (right - left + 1);
                currHeight = currMin;
            }
            if (A[left] < A[right]) {
                block += A[left++];
            } else {
                block += A[right--];
            }
        }
        return all - block;
    }

    private int trap(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int sum = 0;
        if (A[start] <= A[end]) {
            int height = A[start];
            int i;
            for (i = start + 1; i < end; i++) {
                if (A[i] > height) {
                    break;
                }
                sum += height - A[i];
            }
            if (i != end) {
                sum += trap(A, i, end);
            }
        } else {
            int height = A[end];
            int i;
            for (i = end - 1; i > start; i--) {
                if (A[i] > height) {
                    break;
                }
                sum += height - A[i];
            }
            if (i != start) {
                sum += trap(A, start, i);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] A = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(A));
    }
}
