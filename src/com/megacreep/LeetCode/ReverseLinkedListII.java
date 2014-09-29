package com.megacreep.LeetCode;

/**
 * Created by megacreep on 2014/9/29.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index = head;
        ListNode prevTail = dummy;
        int i;
        for (i = 1; i < m; i++) {
            index = index.next;
            prevTail = prevTail.next;
        }

        ListNode subHead = null;
        ListNode subTail = index;
        for (; i <= n; i++) {
            ListNode temp = index.next;
            index.next = subHead;
            subHead = index;
            index = temp;
        }
        prevTail.next = subHead;
        subTail.next = index;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] number = new int[]{1, 2, 3, 4, 5};
        ListNode head = Utils.generateLinkedList(number);
        Utils.printList(new ReverseLinkedListII().reverseBetween(head, 2, 4));

    }
}
