package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {

    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> line = new ArrayList<Integer>();
                line.add(1);
                for (int j = 1; j <= i; j++) {
                    int left = res.get(i - 1).get(j - 1);
                    int right = j < i ? res.get(i - 1).get(j) : 0;
                    line.add(left + right);
                }
                res.add(line);
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
