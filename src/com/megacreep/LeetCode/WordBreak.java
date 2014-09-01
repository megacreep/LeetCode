package com.megacreep.LeetCode;

import java.util.Set;
import java.util.SortedSet;
import java.util.regex.Pattern;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(word.length(), maxLength);
        }
        
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canBreak[i] = false;
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!canBreak[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[s.length()];
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] dict = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        String[] dict = new String[] {"aaaa","aa"}; 
        Set<String> dictSet = Utils.generateSet(dict);
//        String s = "aaaaaaa";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(new WordBreak().wordBreak(s, dictSet));
    }

}
