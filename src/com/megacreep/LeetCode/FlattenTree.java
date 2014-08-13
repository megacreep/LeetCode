package com.megacreep.LeetCode;

public class FlattenTree {
    private TreeNode lastNode;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right=  root.right;
        flatten(root.left);
        flatten(right);
    }
    private TreeNode flattenNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        TreeNode rightTail = flattenNode(root.right);
        TreeNode leftTail = flattenNode(root.left);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null? leftTail : rightTail;
    }
}
