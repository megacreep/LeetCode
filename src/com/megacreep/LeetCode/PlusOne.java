package com.megacreep.LeetCode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean hasCarry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                hasCarry = false;
                break;
            }
        }
        if (!hasCarry) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
    }
}
