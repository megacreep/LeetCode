package com.megacreep.LeetCode;

/**
 * Created by megacreep on 2014/9/25.
 */
public class Division {
    public int divide(int dividend, int divisor) {
        boolean neg = dividend > 0 != divisor > 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int res = 0;

        while (a >= b) {
            int shift = 0;
            while ((b << shift) <= a) {
                shift++;
            }
            res += 1 << (shift - 1);
            a -= b << (shift - 1);
        }

        return neg? -res : res;
    }

    public static void main(String[] args) {
        Division div = new Division();
        System.out.println(div.divide(1, 2) + " " + (1 / 2));
        System.out.println(div.divide(-1169994976, 158107113) + " " + (int)(-1169994976 / 158107113));
    }
}
