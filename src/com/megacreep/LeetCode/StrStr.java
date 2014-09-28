package com.megacreep.LeetCode;

public class StrStr {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return null;
        }
        if (needle.isEmpty()) {
            return haystack;
        }
        int[] table = makeKMPTable(needle);
        int start = 0;
        int offset = 0;
        while (start + offset < haystack.length() && offset < needle.length()) {
            if (haystack.charAt(start + offset) == needle.charAt(offset)) {
                offset++;
            } else {
                if (table[offset] == -1) {
                    start = start + 1;
                    offset = 0;
                } else {
                    start = start + offset - table[offset];
                    offset = table[offset];
                }
            }
        }

        if (offset == needle.length()) {
            return haystack.substring(start);
        } else {
            return null;
        }
    }

    private int[] makeKMPTable(String S) {
        int[] table = new int[S.length()];

        int pos = 2;
        int i = 0;
        table[0] = -1;
        if (S.length() == 1) {
            return table;
        }
        table[1] = 0;

        while (pos < S.length()) {
            if (S.charAt(pos - 1) == S.charAt(i)) {
                i++;
                table[pos] = i;
                pos++;
            } else if (i > 0) {
                i = table[i];
            } else {
                table[pos] = 0;
                pos++;
            }
        }

        return table;
    }

    public static void main(String[] args) {
        String haystack = "haystack";
        String needle = "abcdabd";

        System.out.println(new StrStr().strStr(haystack, needle));
    }
}
