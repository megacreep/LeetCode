package com.megacreep.LeetCode;

/**
 * Created by limy on 14-7-12.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > 0 && x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || rev / 10 == x;
    }

    public boolean isPalindromeUgly(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10 && x >= 0) {
            return true;
        }
        int digit = 2;
        int divider = 10;
        if (x > 1000000000) {
            digit = 10;
            divider = 1000000000;
        } else {
            while (x / divider != 0) {
                digit++;
                divider *= 10;
            }
            divider /= 10;
        }
        int lower = 1;
        int higher = digit;
        int moder = 10;
        while (lower <= higher) {
            int lowerDigit = x % moder / (moder / 10);
            int higherDigit = x / divider % 10;
            System.out.println(lower + " " + higher);
            if (lowerDigit != higherDigit) {
                return false;
            } else {
                lower++;
                higher--;
                moder *= 10;
                divider /= 10;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(12));
    }
}
