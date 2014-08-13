package com.megacreep.LeetCode;

public class JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int maxPosition = 0;
        for (int i = 0; i < A.length - 1 && i <= maxPosition && maxPosition < A.length; i++) {
            if (i + A[i] > maxPosition) {
                maxPosition = i + A[i];
            }
        }
        
        return maxPosition >= A.length - 1;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
    }

}
