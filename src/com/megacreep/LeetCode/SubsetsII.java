package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by megacreep on 2014/9/29.
 */
public class SubsetsII {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private LinkedList<Integer> prefix = new LinkedList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        result.add(prefix);
        findSubsets(num, 0);
        return result;
    }

    private void findSubsets(int[] num, int start) {
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            prefix.add(num[i]);
            result.add(new ArrayList<Integer>(prefix));
            findSubsets(num, i + 1);
            prefix.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 2};
        Utils.printList(new SubsetsII().subsetsWithDup(num));
    }
}
