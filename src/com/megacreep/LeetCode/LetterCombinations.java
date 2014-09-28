package com.megacreep.LeetCode;

import java.util.*;

/**
 * Created by limy on 14-9-27.
 */
public class LetterCombinations {
    private static final char[][] table = new char[][] {
            {' '},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    private char[] prefix;
    private List<String> result = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        prefix = new char[digits.length()];
        visitDigit(digits, 0);
        return result;
    }
    private void visitDigit(String digits, int position) {
        if (position == digits.length()) {
            result.add(new String(prefix));
            return;
        } else {
            for (char letter : table[digits.charAt(position) - '0']) {
                prefix[position] = letter;
                visitDigit(digits, position + 1);
            }
        }
    }

    public static void main(String[] args) {
        Utils.printArray(new LetterCombinations().letterCombinations("23"));
    }
}
