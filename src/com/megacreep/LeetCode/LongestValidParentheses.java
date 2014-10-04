package com.megacreep.LeetCode;

import java.util.Stack;

/**
 * Created by megacreep on 2014/10/3.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> positions = new Stack<Integer>();
        int max = 0;
        int localMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                positions.push(i);
            } else {
                if (positions.isEmpty()) {
                    continue;
                }
                max = Math.max(max, i - positions.pop() + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
