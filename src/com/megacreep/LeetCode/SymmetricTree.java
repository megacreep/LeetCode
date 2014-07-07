package com.megacreep.LeetCode;

import java.util.Stack;

public class SymmetricTree {
    
    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left != null && right != null) {
                return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            } else {
                return left == null && right == null;
            }
        }
        
        public boolean isSymmetricInterative(TreeNode root) {
            if (root == null) {
                return true;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            Stack<TreeNode> leftStack = new Stack<>();
            Stack<TreeNode> rightStack = new Stack<>();
            while (true) {
                if (left != null && right != null) {
                    if (left.val == right.val) {
                        leftStack.push(left);
                        rightStack.push(right);
                        left = left.left;
                        right = right.right;
                    } else {
                        return false;
                    }
                } else if (left != null || right != null){
                    return false;
                } else {
                    if (leftStack.isEmpty()) {
                        return true;
                    }
                    left = leftStack.pop().right;
                    right = rightStack.pop().left;
                }
            }
        }
    }
}
