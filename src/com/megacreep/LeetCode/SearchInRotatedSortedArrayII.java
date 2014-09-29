package com.megacreep.LeetCode;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }

    private boolean search(int[] A, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int middle = (start + end) / 2;
        if (A[middle] == target || A[start] == target || A[end] == target) {
            return true;
        }

        start++;
        end--;

        int lowerMid = middle - 1;
        while (lowerMid >= start && A[lowerMid] == A[middle]) {
            lowerMid--;
        }
        int upperMid = middle + 1;
        while (upperMid <= end && A[upperMid] == A[middle]) {
            upperMid++;
        }
        if (lowerMid < start) {
            return search(A, target, upperMid, end);
        } else if (upperMid > end) {
            return search(A, target, start, lowerMid);
        } else {
            if (A[lowerMid] > A[start]) {
                if (target >= A[start] && target <= A[lowerMid]) {
                    return search(A, target, start, lowerMid);
                } else {
                    return search(A, target, upperMid, end);
                }
            } else {
                if (target >= A[upperMid] && target <= A[end]) {
                    return search(A, target, upperMid, end);
                } else {
                    return search(A, target, start, lowerMid);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{10, 10, 10, -10, -10, -10, -10, -9, -9, -9, -9, -9, -9, -9, -8, -8, -8, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10};
        int target = -6;
        System.out.println(new SearchInRotatedSortedArrayII().search(A, target));
    }
}
