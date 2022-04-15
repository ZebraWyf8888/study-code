package aaaaahot;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    Map<Integer,Node> cache = new HashMap();

    Node head;
    Node tail;

    int size;
    int cap;

    public LRUCache(int cap){
        this.size = 0;
        this.cap = cap;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > cap) {
                Node node1 = removeTail();
                cache.remove(node1.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node pre = tail.pre;
        removeNode(pre);
        return pre;

    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}
