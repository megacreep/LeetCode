package com.megacreep.LeetCode;

/**
 * Created by limy on 14-9-24.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        int carry = 0;
        while (carry != 0 || l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            res.next = new ListNode(sum % 10);
            res = res.next;
            carry = sum / 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        Utils.printList(new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
