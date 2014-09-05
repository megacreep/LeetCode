package com.megacreep.LeetCode;

public class MaxProfitIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int length = prices.length;
        int[] left = new int[length];
        int[] right = new int[length];
        
        int min = prices[0];
        left[0] = 0;
        for (int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(prices[i] - min, left[i - 1]);
        }
        
        int max = prices[length - 1];
        right[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitIII().maxProfit(new int[]{2,1,2,0,1}));
    }
}
