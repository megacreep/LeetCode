package com.megacreep.LeetCode;

public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                total += tank;
                start = i;
                tank = 0;
            }
        }
        return (total + tank) >= 0? start : -1;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(
                new int[]{1,2,3,4,5}, 
                new int[]{3,4,5,1,2}));
    }

}
