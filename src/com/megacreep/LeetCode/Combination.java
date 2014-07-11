package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by limy on 14-7-12.
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        return combine(1, n, k);
    }
    public List<List<Integer>> combine(int start, int end, int k) {
        if (end - start + 1 < k) {
            return Collections.emptyList();
        }
        List<List<Integer>> result;
        if (k == 1) {
            result = new ArrayList<List<Integer>>();
            for (int i = start; i <= end; i++) {
                List<Integer> c = new ArrayList<Integer>();
                c.add(i);
                result.add(c);
            }
            return result;
        } else {
            result = combine(start, end - 1, k - 1);
            for (List<Integer> c : result) {
                c.add(end);
            }
            result.addAll(combine(start, end - 1, k));
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combination().combine(4, 2);
        Utils.printList(result);
    }
}
