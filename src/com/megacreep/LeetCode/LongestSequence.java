package com.megacreep.LeetCode;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LongestSequence {

    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        int maxLength = 0;
        for (int number : num) {
            if (mapping.containsKey(number)) {
                continue;
            }
            int lowerBound = number;
            int upperBound = number;
            if (mapping.containsKey(number - 1)) {
                lowerBound = mapping.get(number - 1);
            }
            if (mapping.containsKey(number + 1)) {
                upperBound = mapping.get(number + 1);
            }
            mapping.put(number, number);
            mapping.put(lowerBound, upperBound);
            mapping.put(upperBound, lowerBound);
            if (upperBound - lowerBound > maxLength) {
                maxLength = upperBound - lowerBound;
            }
        }
        return maxLength + 1;
    }
    public static void main(String[] args) {
        int[] num = new int[]{1,3,5,7,9,2,4,6,8,10};
        System.out.println(new LongestSequence().longestConsecutive(num));
    }
}
