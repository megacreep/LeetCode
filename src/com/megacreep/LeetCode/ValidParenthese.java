package com.megacreep.LeetCode;

import java.util.Stack;

public class ValidParenthese {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (c == ')' && top != '('
                        || c == '{' && top != '}'
                        || c == '[' && top != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(new ValidParenthese().isValid("(){}[]{}[{}{}{}{}{}]["));
    }
}
