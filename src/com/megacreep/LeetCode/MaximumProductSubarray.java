package com.megacreep.LeetCode;

import java.util.ArrayList;

/**
 * Created by limy on 14-9-26.
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] A) {
        int max = A[0];

        int preMax = A[0];
        int preMin = A[0];
        for (int i = 1; i < A.length; i++) {
            int val = preMax * A[i];
            int valB = preMin * A[i];
            preMax = Math.max(Math.max(val, A[i]), valB);
            preMin = Math.min(Math.min(val, A[i]), valB);
            if (preMax > max) {
                max = preMax;
            }
        }
        return max;
    }

    public int maxProductTemp(int[] A) {
        int max = Integer.MIN_VALUE;

        int product = 1;
        int negCount = 0;
        int start = 0;
        for (int i = 0; i <= A.length; i++) {
            if (i == A.length || A[i] == 0) {
                int tempMax = calculateMax(A, start, i, product, negCount);
                max = Math.max(tempMax, max);
                product = 1;
                negCount = 0;
                start = i + 1;
            } else {
                product *= A[i];
                if (A[i] < 0) {
                    negCount ++;
                }
            }
        }
        return max;
    }

    private int calculateMax(int[] A, int start, int end, int product, int negCount) {
        if (negCount % 2 == 0) {
            return product;
        } else if (end - start <= 1) {
            return A[start];
        } else {
            int leftProduct = product;
            for (int i = start; i < end; i++) {
                leftProduct /= A[i];
                if (A[i] < 0) {
                    break;
                }
            }
            int rightProduct = product;
            for (int i = end - 1; i >= start; i--) {
                rightProduct /= A[i];
                if (A[i] < 0) {
                    break;
                }
            }
            return Math.max(leftProduct, rightProduct);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{0};

        System.out.println(new MaximumProductSubArray().maxProduct(A));

    }
}
