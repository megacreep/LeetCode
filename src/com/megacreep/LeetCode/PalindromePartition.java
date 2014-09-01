package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        int length = s.length();
        List<List<String>>[] result = new List[length + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        
        boolean[][] pair = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            result[i + 1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    pair[j][i] = true;
                } else {
                    if (s.charAt(j) != c) {
                        continue;
                    }
                    if (i - j == 1) {
                        pair[j][i] = true;
                    } else {
                        pair[j][i] = pair[j + 1][i - 1];
                    }
                }
                if (pair[j][i]) {
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> temp = new ArrayList<String>(r);
                        temp.add(str);
                        result[i + 1].add(temp);
                    }
                }
            }
        }
        
        return result[length];
    }
    
    public static void main(String[] args) {
        Utils.printList(new PalindromePartition().partition("abaaba"));
    }
}
