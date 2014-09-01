package com.megacreep.LeetCode;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        
        int descLength = 0;
        int maxCandy = 1;
        int prevCandy = 1;
        int count = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                descLength++;
                if (descLength == maxCandy) {
                    descLength++;
                }
                count += descLength;
                prevCandy = 1;
            } else {
                if (ratings[i] > ratings[i - 1]) {
                    prevCandy++;
                } else {
                    prevCandy = 1;
                }
                count += prevCandy;
                descLength = 0;
                maxCandy = prevCandy;
            }
        }
        
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
