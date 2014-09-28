package com.megacreep.LeetCode;

public class StrStr {
    public String strStr(String haystack, String needle) {
        int[] quickback = new int[needle.length()];
        quickback[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            int back = quickback[i - 1];
            while (back != -1) {
                if (needle.charAt(back + 1) == needle.charAt(i)) {
                    quickback[i] = back + 1;
                    break;
                } else {
                    back = quickback[back];
                }
            }
            if (back == -1) {
                quickback[i] = -1;
            }
        }

        Utils.printArray(quickback);
//
//        int start = 0;
//        while (start < haystack.length()) {
//            int index = 0;
//            while (index < needle.length()) {
//                if (haystack.charAt(start + index) == needle.charAt(index)) {
//                    index++;
//                } else {
//
//                }
//            }
//            if (index == needle.length()) {
//                break;
//            }
//        }
//        return start == haystack.length() ? null : haystack.substring(start);
        return null;
    }

    public static void main(String[] args) {
        String haystack = "haystack";
        String needle = "aaaaaaaa";

        new StrStr().strStr(haystack, needle);
    }
}
