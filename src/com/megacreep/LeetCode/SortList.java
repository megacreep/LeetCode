package com.megacreep.LeetCode;

public class SortList {
    private ListNode nextNode;
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return mergeSort(head, length);
    }
    
    private ListNode mergeSort(ListNode head, int length) {
        if (length <= 1) {
            nextNode = head.next;
            return head;
        }
        ListNode leftHead = mergeSort(head, length / 2);
        ListNode rightHead = mergeSort(nextNode, length - length / 2);
        return merge(leftHead, rightHead, length / 2, length - length / 2);
    }
    private ListNode merge(ListNode left, ListNode right, int leftLength, int rightLength) {
        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;
        while (leftLength > 0 && rightLength > 0) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
                leftLength--;
            } else {
                curr.next = right;
                right = right.next;
                rightLength--;
            }
            curr = curr.next;
        }
        if (leftLength > 0) {
            curr.next = left;
            while (--leftLength > 0) {
                left = left.next;
            }
            left.next = right;
        } else {
            curr.next = right;
        }
        return tempHead.next;
    }
    
    public static void main(String[] args){
        ListNode list = Utils.generateLinkedList(new int[] {1,2,3,6,1,2,5,8,4,3,1,3,5,8,8,6,5,23,1,12,3,5,45,8,8,6,5,3,2,3,4,56,5,423,13,5,8,8,5});//
        Utils.printList(list);
        System.out.println();
        Utils.printList(new SortList().sortList(list));
    }
}
