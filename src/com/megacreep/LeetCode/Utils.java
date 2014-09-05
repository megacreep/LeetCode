package com.megacreep.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	public static<T> void printArray(List<T> list) {
		for(T num: list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }

    public static <T> void printList(List<List<T>> result) {
        for (List<T> list: result) {
            printArray(list);
        }
    }

    public static void printArray(String[] strs) {
        for(String str : strs) {
            System.out.println(str);
        }
    }
    
    public static ListNode generateLinkedList(int[] numbers) {
        ListNode tempHead = new ListNode(-1);
        ListNode prev = tempHead;
        for (int number : numbers) {
            ListNode node = new ListNode(number);
            prev.next = node;
            prev = node;
        }
        return tempHead.next;
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " " );
            list = list.next;
        }
        System.out.println();
    }
    public static void printList(ListNode list, int length) {
        while(length-- > 0) {
            System.out.print(list.val + " " );
            list = list.next;
        }
    }

    public static Set<String> generateSet(String[] dict) {
        Set<String> set = new HashSet<String>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }

    public static void printArray(int[] array) {
        // TODO Auto-generated method stub
        
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        
    }
}
