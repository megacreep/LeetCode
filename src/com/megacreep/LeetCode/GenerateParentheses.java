package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("(");
        }
        int mostLeft = n;
        int left = mostLeft;
        int right = 0;
        while (mostLeft > 0) {
            for (right = mostLeft; right > 0; right--) {
                
            }
        }
        return result;
    }
    
    
    public List<String> generateParenthesisMime(int n) {
        List<Set<String>> results = new ArrayList<>();
        Set<String> result = new HashSet<String>();
        result.add("()");
        results.add(result);
        for (int num = 2; num <= n; num++) {
            result = new HashSet<String>();
            for (int i = 1; i < num; i++) {
                Set<String> leftSet = results.get(i - 1);
                Set<String> rightSet = results.get(num - i - 1);
                for (String left: leftSet) {
                    for (String right: rightSet) {
                        result.add(left.concat(right));
                    }
                }
            }
            for (String inner : results.get(num - 2)) {
                result.add("(" + inner + ")");
            }
            results.add(result);
        }
        return Arrays.asList(results.get(n - 1).toArray(new String[results.get(n - 1).size()]));
    }
    
    public static void main(String[] args) { 
        for (String str : new GenerateParentheses().generateParenthesis(4)) {
            System.out.println(str);
        }
    }
}
