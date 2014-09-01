package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    Map<String, List<String>> path = new HashMap<String, List<String>>();
    
    public List<String> wordBreak(String s, Set<String> dict) {
        if (path.containsKey(s)) {
            return path.get(s);
        }
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() == 0) {
            return result;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == s.length()) {
                    result.add(prefix);
                } else {
                    String suffix = s.substring(i);
                    List<String> temp = wordBreak(suffix, dict);
                    for (String str : temp) {
                        result.add(prefix + " " + str);
                    }
                }
            }
        }
        path.put(s, result);
        return result;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] dict = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        String[] dict = new String[] {"aaaa","aa"}; 
        Set<String> dictSet = Utils.generateSet(dict);
//        String s = "aaaaaa";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(new WordBreakII().wordBreak(s, dictSet));
    }

}
