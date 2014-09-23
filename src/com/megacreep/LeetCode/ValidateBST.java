package com.megacreep.LeetCode;

/**
 * Created by limy on 14-9-23.
 */
public class ValidateBST {
    private TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;
        return isValidBST(root.right);
    }
}
