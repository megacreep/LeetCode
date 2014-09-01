package com.megacreep.LeetCode;

import java.util.HashSet;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || slow == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }
        } while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public ListNode detectCycleChangeVal(ListNode head) {
        while (head != null) {
            if (head.val == Integer.MAX_VALUE) {
                return head;
            } else {
                head.val = Integer.MAX_VALUE;
                head = head.next;
            }
        }
        return null;
    }
}
