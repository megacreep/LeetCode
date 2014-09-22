package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by megacreep on 2014/9/25.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String s = new String(sorted);
            List<String> res = map.get(s);
            if (res == null) {
                res = new ArrayList<String>();
                map.put(s, res);
            }
            res.add(str);
        }

        for (List<String> group : map.values()) {
            if (group.size() >= 2) {
                result.addAll(group);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {
        "dog","cat","god","tac"
        };
        Utils.printArray(new Anagrams().anagrams(strs));
    }
}
