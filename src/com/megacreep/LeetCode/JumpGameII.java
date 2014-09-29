package com.megacreep.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by megacreep on 2014/9/28.
 */
public class JumpGameII {
    public int jump(int[] A) {
        int level = 0;
        int max = 0;
        int start = 0;
        while (max < A.length - 1) {
            int localMax = max;
            for (int i = start; i <= max; i++) {
                localMax = Math.max(localMax, i + A[i]);
            }
            if (localMax == max) {
                return -1;
            }
            start = max + 1;
            max = localMax;
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jump(A));
    }
}
