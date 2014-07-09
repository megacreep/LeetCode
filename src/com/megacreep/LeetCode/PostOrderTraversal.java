package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            if (curr.left != null) {
                stack.push(curr);
            }
        }
    }
    
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        if (root.left != null || root.right != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
    }

}
