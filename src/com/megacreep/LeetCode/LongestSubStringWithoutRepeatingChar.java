package com.megacreep.LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by megacreep on 2014/10/3.
 */
public class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<Character> existing = new LinkedHashSet<Character>();
        int max = 0;
        for (char c : s.toCharArray()) {
            if (existing.contains(c)) {
                Iterator<Character> iterator = existing.iterator();
                while (iterator.next() != c) {
                    iterator.remove();
                }
                iterator.remove();
            }
            existing.add(c);
            max = Math.max(max, existing.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaab";
        System.out.println(new LongestSubStringWithoutRepeatingChar().lengthOfLongestSubstring(s));
    }
}
