package com.megacreep.LeetCode;

/**
 * Created by megacreep on 2014/9/29.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                head = findNext(head);
            } else {
                prev.next = head;
                prev = head;
                head = head.next;
            }
        }
        prev.next = head;

        return dummy.next;
    }

    private ListNode findNext(ListNode head) {
        int val = head.val;
        while (head != null && head.val == val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1};
        ListNode head = Utils.generateLinkedList(numbers);
        Utils.printList(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));

    }
}
