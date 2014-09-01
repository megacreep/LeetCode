package com.megacreep.LeetCode;

public class ReorderList {

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode prev = head;
        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        boolean useA = true;
        ListNode curr = head;
        while (a != null && b != null) {
            if (useA) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            useA = !useA;
            curr = curr.next;
        }
        if (a != null) {
            curr.next = a;
        } else {
            curr.next = b;
        }
        return head.next;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode mid = findMiddle(head);
        ListNode reverseHead = reverseList(mid.next);
        mid.next = null;
        merge(head, reverseHead);
    }
    
    public void reorderListRecursive(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        reorderList(head, length);
    }
    
    private ListNode reorderList(ListNode head, int length) {
        ListNode next = null;
        if (length == 1) {
            next = head.next;
            head.next = null;
        } else if (length == 2) {
            next = head.next.next;
            head.next.next = null;
        } else {
            ListNode temp = reorderList(head.next, length - 2);
            next = temp.next;
            temp.next = head.next;
            head.next = temp;
        }
        return next;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode list = Utils.generateLinkedList(new int[] {1,2,3,4,5,6});
        new ReorderList().reorderList(list);
        Utils.printList(list);
    }

}
