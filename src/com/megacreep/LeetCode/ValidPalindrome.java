package com.megacreep.LeetCode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            if (!isAlphabetic(startChar)) {
                start++;
                continue;
            }
            char endChar = s.charAt(end);
            if (!isAlphabetic(endChar)) {
                end--;
                continue;
            }
            if (isEqualIgnoreCase(startChar, endChar)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean isEqualIgnoreCase(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
    
    private boolean isAlphabetic(char c) {
        return Character.isLetterOrDigit(c);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String string = "race a car";
        System.out.println(new ValidPalindrome().isPalindrome(string));
    }

}
