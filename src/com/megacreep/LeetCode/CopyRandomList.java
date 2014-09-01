package com.megacreep.LeetCode;

public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode oldIndex = head;
        while (oldIndex != null) {
            RandomListNode temp = oldIndex.next;
            RandomListNode newNode = new RandomListNode(oldIndex.label);
            newNode.next = temp;
            oldIndex.next = newNode;
            oldIndex = temp;
        }
        RandomListNode newHead = head.next;

        oldIndex = head;
        RandomListNode newIndex = newHead;
        while (oldIndex != null) {
            if (oldIndex.random != null) {
                newIndex.random = oldIndex.random.next;
            }
            oldIndex = newIndex.next;
            newIndex = oldIndex == null? null : oldIndex.next;
        }

        oldIndex = head;
        newIndex = newHead;
        while (oldIndex != null) {
            oldIndex.next = newIndex.next;
            oldIndex = oldIndex.next;
            newIndex.next = oldIndex == null? null : oldIndex.next;
            newIndex = newIndex.next;
        }
        
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(-1);
        head.next = null;
        head.random = null;
        new CopyRandomList().copyRandomList(head);
    }
}
