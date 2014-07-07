package com.megacreep.LeetCode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > lowest) {
                if (prices[i] - lowest > profit) {
                    profit = prices[i] - lowest;
                }
            } else if (lowest > prices[i]) {
                lowest = prices[i];
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{2,1,2,0,1}));
    }
}
