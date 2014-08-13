package com.megacreep.LeetCode;

import java.util.Arrays;

public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start > end) {
            return "";
        }
        if (start == end) {
            return strs[start];
        }

        int middle = (end + start) / 2; 
        String firstHalf = longestCommonPrefix(strs, start, middle);
        String secondHalf = longestCommonPrefix(strs, middle + 1, end); 
        
        return getCommonPrefix(firstHalf, secondHalf);
    }
    
    private String getCommonPrefix(String first, String second) {
        int i = 0;
        for (; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                break;
            }
        }
        return first.substring(0, i);
    }
    
    public String longestCommonPrefixOld(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first;
    }
    public static void main(String[] args) {
        System.out.println(new LongestPrefix().longestCommonPrefix(new String[]{"c", "c"}));
    }
}
