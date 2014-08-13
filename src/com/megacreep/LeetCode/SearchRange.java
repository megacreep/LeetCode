package com.megacreep.LeetCode;

public class SearchRange {

    public int[] searchRange(int[] A, int target) {
        return searchRange(A, target, 0, A.length - 1);
    }
    
    private int[] searchRange(int[] A, int target, int start, int end) {
        int lower = -1;
        int upper = -1;
        if (start == end) {
            if (A[start] == target) {
                lower = upper = start;
            }
        } 
        if (start < end) {
            int middle = (end + start) / 2;
            if (A[middle] == target) {
                int[] lowerResult = searchRange(A, target, start, middle - 1);
                int[] upperResult = searchRange(A, target, middle + 1, end);
                if (lowerResult[0] != -1) {
                    lower = lowerResult[0];
                } else {
                    lower = middle;
                }
                if (upperResult[1] != -1) {
                    upper = upperResult[1];
                } else {
                    upper = middle;
                }
            } else if (A[middle] < target) {
                return searchRange(A, target, middle + 1, end);
            } else {
                return searchRange(A, target, start, middle - 1);
            }
        }
        
        return new int[] {lower, upper};
    }
    
    public static void main(String[] args) {
        Utils.printArray(new SearchRange().searchRange(new int[] {5, 8, 8, 8, 8, 10}, 8));
    }
}
