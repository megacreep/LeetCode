package com.megacreep.LeetCode;

public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null && next != null) {
            curr = insert(dummy, curr, next);
            next = curr.next;
        }
        return dummy.next;
    }

    private ListNode insert(ListNode dummy, ListNode curr, ListNode next) {
        ListNode index = dummy.next;
        ListNode prev = dummy;
        while (prev != curr) {
            if (next.val <= index.val) {
                curr.next = next.next;
                prev.next = next;
                next.next = index;
                return curr;
            } else {
                index = index.next;
                prev = prev.next;
            }
        }
        return next;
    }
    
    public static void main(String[] args){
        ListNode list = Utils.generateLinkedList(new int[] {1,2,3,6,1,2,5,8,4,3,1,3,5,8,8,6,5,23,1,12,3,5,45,8,8,6,5,3,2,3,4,56,5,423,13,5,8,8,5});//
        Utils.printList(list);
        Utils.printList(new InsertionSort().insertionSortList(list));
    }
}
