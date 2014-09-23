package com.megacreep.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by limy on 14-9-23.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] canInterleave = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    canInterleave[i][j] = true;
                } else {
                    canInterleave[i][j] = false;
                    if (i > 0) {
                        canInterleave[i][j] |= canInterleave[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    }
                    if (j > 0) {
                        canInterleave[i][j] |= canInterleave[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    }
                }
            }
        }

        return canInterleave[s1.length()][s2.length()];
    }

    public boolean isInterleaveRecur(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int index1 = 0;
        int index2 = 0;
        int i;
        for (i = 0; i < s3.length() && (index1 < s1.length() || index2 < s2.length()); i++) {
            boolean firstSame = index1 < s1.length() && s1.charAt(index1) == s3.charAt(i);
            boolean secondSame = index2 < s2.length() && s2.charAt(index2) == s3.charAt(i);
            if (firstSame && secondSame) {
                return isInterleaveRecur(s1.substring(index1 + 1), s2.substring(index2), s3.substring(i + 1))
                        || isInterleaveRecur(s1.substring(index1), s2.substring(index2 + 1), s3.substring(i + 1));
            }

            if (firstSame) {
                index1++;
                continue;
            }
            if (secondSame) {
                index2++;
                continue;
            }

            return false;
        }

        return i == s3.length();
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        long start = System.currentTimeMillis();
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}
