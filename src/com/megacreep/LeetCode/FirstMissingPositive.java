package com.megacreep.LeetCode;

/**
 * Created by megacreep on 2014/9/25.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int target = A[i];
            while (target > 0 && target - 1 < length && A[target - 1] != target) {
                int newTarget = A[target - 1];
                A[target - 1] = target;
                target = newTarget;
            }
        }

        for (int i = 0; i < length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }


    public static void main(String[] args) {
        int[] A = new int[]{2, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(A));
    }
}
