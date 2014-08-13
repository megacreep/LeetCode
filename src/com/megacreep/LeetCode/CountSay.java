package com.megacreep.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class CountSay {

    public String countAndSay(int n) {
        String result = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] chars = result.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int count = 1;
                while ((i + 1) < chars.length && chars[i] == chars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(chars[i]);
            }
            result = sb.toString();
        }
        return result;
    }
    
    public String countAndSayQueue(int n){
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.push(1);
        Deque<Integer> tempQueue = new LinkedList<Integer>();
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            int number = queue.pop();
            while (!queue.isEmpty()) {
                int currNumber = queue.pop();
                if (number == currNumber) {
                    count++;
                } else {
                    tempQueue.offer(count);
                    tempQueue.offer(number);
                    number = currNumber;
                    count = 1;
                }
            }
            tempQueue.offer(count);
            tempQueue.offer(number);
            Deque<Integer> temp = tempQueue;
            tempQueue = queue;
            queue = temp;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pop());
        }

        return sb.toString();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new CountSay().countAndSay(i));
        }
    }

}
