package com.megacreep.LeetCode;

public class RotateSearch {
    public int search(int[] A, int target) {
        return searchRecur(A, target, 0, A.length - 1);
    }
    private int searchRecur(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (A[middle] == target) {
            return middle;
        } else if (A[start] == target) {
            return start;
        } else if ((A[middle] - A[start]) * (target - A[start]) * (A[middle] - target) > 0) {
            return searchRecur(A, target, start + 1, middle - 1);
        } else {
            return searchRecur(A, target, middle + 1, end);
        }
    }
    
    public int searchInter(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (A[middle] == target) {
                return middle;
            } else {
                if (A[start] == target) {
                    return start;
                }
                if ((A[middle] - A[start]) * (target - A[start]) * (A[middle] - target) > 0) {
                    end = middle - 1;
                    start++;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = new int[]{6,7,8,1,2,3,4,5};
        System.out.println(new RotateSearch().search(A, 3));
    }
}
