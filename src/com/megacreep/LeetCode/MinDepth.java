package com.megacreep.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by limy on 14-7-12.
 */
public class MinDepth {
    public int minDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }


    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode anchor = new TreeNode(-1);
        queue.offer(anchor);
        depth++;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == anchor) {
                queue.offer(anchor);
                depth++;
                continue;
            }
            if (curr.left == null && curr.right == null) {
                return depth;
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(new MinDepth().minDepth(root));
    }
}
