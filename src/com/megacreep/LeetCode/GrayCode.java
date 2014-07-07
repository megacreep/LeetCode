package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << n;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + inc);
            }
        }
        return result;
    }
    
    public List<Integer> myGrayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int num = 0;
        result.add(num);
        int maxCount = (int) Math.pow(2, n);
        int count = 1;
        while (count < maxCount) {
            num ^= 1 << getDigit(count);
            result.add(num);
            count++;
        }
        return result;
    }
    private int getDigit(int count) {
        int digit = 0;
        while (count % 2 == 0) {
            digit++;
            count /= 2;
        }
        return digit;
    }
    public static void main(String[] args) {
        List<Integer> result = new GrayCode().grayCode(3);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
