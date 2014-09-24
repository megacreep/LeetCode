package com.megacreep.LeetCode;

import java.util.LinkedHashMap;

/**
 * Created by limy on 14-9-24.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        boolean carry = false;

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < a.length() || index < b.length()) {
            int val = carry? 1 : 0;
            if (index < a.length())
                val += a.charAt(a.length() - index - 1) - '0';
            if (index < b.length())
                val += b.charAt(b.length() - index - 1) - '0';

            if (val >= 2) {
                carry = true;
            } else {
                carry = false;
            }
            sb.insert(0, val % 2);
            index++;
        }

        if (carry) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "1";

        System.out.println(new AddBinary().addBinary(a, b));

    }
}
