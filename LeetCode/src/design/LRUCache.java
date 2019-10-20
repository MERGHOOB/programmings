package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
https://leetcode.com/problems/lru-cache/
 */
class LRUCache {

    int capacity;
    private Map<Integer, Node> cacheTable;
    private Deque<Node> deque = new LinkedList<>();

    public LRUCache(int capacity) {
        cacheTable = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if(!cacheTable.containsKey(key)) {
            return -1;
        }
        update(key);
        return cacheTable.get(key).getValue();
    }

    private void update(int key) {
        Node node = cacheTable.get(key);
        deque.remove(node);
        deque.addFirst(node);
    }

    public void put(int key, int value) {
        if(!cacheTable.containsKey(key)) {
            if(cacheTable.size() == capacity) {
                Node node = deque.removeLast();
                cacheTable.remove(node.key);
            }
            Node node = new Node(key,value);
            cacheTable.put(key, node);
            deque.addFirst(node);
        }
        else {
            Node node = cacheTable.get(key);
            boolean removed = deque.remove(node);
            node.setVal(value);
            if(removed) {
                deque.addFirst(node);
            }

        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private class Node {
        public void setVal(int val) {
            this.val = val;
        }

        private int val;
        private int key;
        private Node(int key,int val) {
            this.val = val;
            this.key = key;
        }

        public int getValue() {

            return val;
        }
    }
}