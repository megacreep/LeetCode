package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by megacreep on 2014/9/25.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return combinationSum(candidates, target, 0);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> one = new ArrayList<Integer>();
                one.add(candidates[i]);
                result.add(one);
            } else {
                List<List<Integer>> subResult = combinationSum(candidates, target - candidates[i], i + 1);
                for (List<Integer> com : subResult) {
                    com.add(0, candidates[i]);
                }
                result.addAll(subResult);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        Utils.printList(new CombinationSumII().combinationSum2(candidates, target));

    }
}
