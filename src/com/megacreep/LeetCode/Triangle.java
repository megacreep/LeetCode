package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by limy on 14-9-4.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int[] total = new int[triangle.size()];
        total[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int tempMin = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int newMin = tempMin;
                if (j < i) {
                    newMin = Math.min(newMin, total[j] + triangle.get(i).get(j));
                    tempMin = total[j] + triangle.get(i).get(j + 1);
                }
                total[j] = newMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < total.length; i++ ){
            if (total[i] < min) {
                min = total[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3,4}));
        triangle.add(Arrays.asList(new Integer[]{5,6,7}));
        triangle.add(Arrays.asList(new Integer[]{4,1,8,3}));

        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
