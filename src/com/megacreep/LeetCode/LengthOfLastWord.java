package com.megacreep.LeetCode;

/**
 * Created by limy on 14-7-14.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int wordEnd = -1;
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (wordEnd != -1) {
                    break;
                }
            } else if (wordEnd == -1) {
                wordEnd = i;
            }
        }
        return wordEnd - i;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("asdf  sdfr"));
    }
}
