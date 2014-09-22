package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4) {
            return result;
        }

        Arrays.sort(num);

        for (int first = 0; first < num.length - 3; first++) {
            if (first != 0 && num[first - 1] == num[first]) {
                continue;
            }
            for (int second = first + 1; second < num.length - 2; second++) {
                if (second != first + 1 && num[second - 1] == num[second]) {
                    continue;
                }
                int third = second + 1;
                int fourth = num.length - 1;
                while (third < fourth) {

                    int sum = num[first] + num[second] + num[third] + num[fourth];
                    if (sum == target) {
                        List<Integer> res = new ArrayList<Integer>();
                        Collections.addAll(res, num[first], num[second], num[third], num[fourth]);
                        result.add(res);
                        do {
                            third++;
                        } while (third < fourth && num[third] == num[third - 1]);
                        do {
                            fourth--;
                        } while (third < fourth && num[fourth] == num[fourth + 1]);
                    } else if (sum < target) {
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[] {1,0,-1,0,-2,2};
        int target = 0;
        Utils.printList(new FourSum().fourSum(num, target));

    }
}
