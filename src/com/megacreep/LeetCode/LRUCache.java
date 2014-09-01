package com.megacreep.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int capacity;
    private Map<Integer, Node> refMap;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.refMap = new HashMap<Integer, LRUCache.Node>();
        firstNode = new Node(0, 0);
        lastNode = new Node(0, 0);
        firstNode.next = lastNode;
        lastNode.next = firstNode;
    }
    
    public int get(int key) {
        if(refMap.containsKey(key)) {
            Node node = refMap.get(key);
            if (node.prev != firstNode) {
                detach(node);
                attach(node);
            }
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (refMap.containsKey(key)) {
            Node node = refMap.get(key);
            node.value = value;
            detach(node);
            attach(node);
        } else {
            if (refMap.size() >= capacity) {
                Node oldNode = lastNode.prev;
                detach(oldNode);
                refMap.remove(oldNode.key);
            }
            Node node = new Node(key, value);
            refMap.put(key, node);
            attach(node);
        }
    }
    
    private void detach(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void attach(Node node) {
        node.next = firstNode.next;
        firstNode.next = node;
        node.prev = firstNode;
        node.next.prev = node;
    }
//    private int capacity;
//    private Map<Integer, Integer> cache;
//    private LinkedList<Integer> visitRecord;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        cache = new HashMap<Integer, Integer>();
//        visitRecord = new LinkedList<Integer>();
//    }
//    
//    public int get(int key) {
//        if (cache.containsKey(key)) {
//            updateVisitRecord(key);
//            return cache.get(key);
//        } else {
//            return -1;
//        }
//    }
//    
//    public void set(int key, int value) {
//        if (cache.containsKey(key)) {
//            updateVisitRecord(key);
//        } else {
//            if (capacity <= cache.size()) {
//                int oldKey = visitRecord.poll();
//                cache.remove(oldKey);
//            }
//            insertVisitRecord(key);
//        }
//        cache.put(key, value);
//    }
//
//    private void insertVisitRecord(int key) {
//        visitRecord.offer(key);
//    }
//    
//    private void updateVisitRecord(int key) {
//        visitRecord.remove(visitRecord.indexOf(key));
//        visitRecord.offer(key);
//    }
}