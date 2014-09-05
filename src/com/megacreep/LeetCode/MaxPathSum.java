package com.megacreep.LeetCode;

public class MaxPathSum {
    
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxSum;
    }

    private int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = getMaxPath(root.left);
        int rightMax = getMaxPath(root.right);
        int localMax = root.val;
        if (leftMax > 0) {
            localMax += leftMax;
        }
        if (rightMax > 0) {
            localMax += rightMax;
        }
        if (localMax > maxSum) {
            maxSum = localMax;
        }
        return root.val + Math.max(0, Math.max(leftMax, rightMax));
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode subNode = new TreeNode(-1);
        node.left = subNode;
        System.out.println(new MaxPathSum().maxPathSum(node));
    }
}
