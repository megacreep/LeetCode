package com.megacreep.LeetCode;

/**
 * Created by limy on 14-7-12.
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calSum(root, 0);
    }

    private int calSum(TreeNode root, int prev) {
        int val = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        } else {
            int sum = 0;
            if (root.left != null) {
                sum += calSum(root.left, val);
            }
            if (root.right != null) {
                sum += calSum(root.right, val);
            }
            return sum;
        }
    }
}
