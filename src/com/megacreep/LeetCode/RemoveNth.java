package com.megacreep.LeetCode;

/**
 * Created by limy on 14-7-12.
 */
public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode anchor = new ListNode(0);
        anchor.next = head;
        ListNode curr = head;
        ListNode deletePrev = anchor;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        while (curr != null) {
            curr = curr.next;
            deletePrev = deletePrev.next;
        }
        deletePrev.next = deletePrev.next.next;
        return anchor.next;
    }
}
