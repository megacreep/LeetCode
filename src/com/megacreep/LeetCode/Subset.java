package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsets(S, S.length);
    }
    
    private List<List<Integer>> subsets(int[] S, int length) {
        if (length <= 1) {
            List<List<Integer>> subset = new ArrayList<List<Integer>>();
            subset.add(new ArrayList<Integer>());
            if (length == 1) {
                ArrayList<Integer> singleList = new ArrayList<Integer>();
                singleList.add(S[0]);
                subset.add(singleList);
            }
            return subset;
        }
        List<List<Integer>> subResult = subsets(S, length - 1);
        int size = subResult.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newList = new ArrayList<Integer>(subResult.get(i));
            newList.add(S[length - 1]);
            subResult.add(newList);
        }
        return subResult;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = new Subset().subsets(new int[] {1,2,3,4,5,6,7,8,9,10});
        System.out.println(result.size());
    }
}
