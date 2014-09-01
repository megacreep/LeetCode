package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitionII {
    public int minCut(String s) {
        int length = s.length();
        int[][] cut = new int[length][length];

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (i == j
                        || (s.charAt(j) == c && (i - j == 1 || cut[j + 1][i - 1] == 0))) {
                    cut[j][i] = 0;
                } else {
                    cut[j][i] = cut[j][i - 1] + 1;
                }
                int currCut = (j > 0 ? (cut[0][j - 1] + 1) : 0) + cut[j][i];
                cut[0][i] = Math.min(cut[0][i], currCut);
            }
        }

        return cut[0][length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitionII().minCut("abacba"));
    }
}
