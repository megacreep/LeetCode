package com.megacreep.LeetCode;

/**
 * Created by limy on 14-9-27.
 */
public class Pow {
    public double pow(double x, int n) {
        boolean neg = n < 0;
        long factor = Math.abs((long)n);

        int length = 1;
        while ((long)1 << length <= factor) {
            length++;
        }

        System.out.println("Length: " + length);

        double[] power = new double[length];
        power[0] = x;
        for (int i = 1; i < length; i++) {
            power[i] = power[i - 1] * power[i - 1];
        }

        double result = 1;
        for (int i = length - 1; i >= 0 && factor != 0; i--) {
            if (((long)1 << i) > factor) {
                continue;
            }
            result *= power[i];
            factor -= ((long)1 << i);
        }
        return neg? 1 / result : result;
    }

    public static void main(String[] args) {
        double x = 8.88023;
        int n = 3;
        System.out.println(new Pow().pow(x, n) + "\n" + Math.pow(x, n));
    }
}
