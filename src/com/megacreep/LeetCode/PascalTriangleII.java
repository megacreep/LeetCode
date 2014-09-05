package com.megacreep.LeetCode;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                res[j] += res[j - 1];
            }
        }

        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(3));
    }
}
