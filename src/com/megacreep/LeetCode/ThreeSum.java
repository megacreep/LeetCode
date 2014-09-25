package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by limy on 14-9-25.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);

        Integer lastNum = null;
        for (int i = 0; i < num.length - 2; i++) {
            if (lastNum != null && lastNum == num[i]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    List<Integer> line = new ArrayList<Integer>();
                    Collections.addAll(line, num[i], num[left], num[right]);
                    result.add(line);
                    do {
                        left++;
                    } while (num[left] == num[left - 1]);
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
            lastNum = num[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{-2,0,0,2,2};
        Utils.printList(new ThreeSum().threeSum(num));

    }

}
