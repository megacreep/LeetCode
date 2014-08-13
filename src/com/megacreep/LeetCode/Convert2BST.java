package com.megacreep.LeetCode;

public class Convert2BST {

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(-1);
        convert(head, root, length);
        return root;
    }

    private ListNode convert(ListNode head, TreeNode root, int length) {
        TreeNode leftRoot = null;
        TreeNode rightRoot = null;
        ListNode temp = head;
        if (length / 2 > 0) {
            leftRoot = new TreeNode(-1);
            temp = convert(head, leftRoot, length / 2);
        }
        root.val = temp.val;
        temp = temp.next;
        int rightHalfLength = length - (length / 2 + 1);
        if (rightHalfLength > 0) {
            rightRoot = new TreeNode(-1);
            temp = convert(temp, rightRoot, rightHalfLength);
        }
        root.left = leftRoot;
        root.right = rightRoot;
        return temp;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        
    }

}
