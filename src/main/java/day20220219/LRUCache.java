package day20220219;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
class LRUCache2 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

class LRUCache3 {

    public class DQ {
        DQ pre;
        DQ next;
        int value;
        int key;

        public DQ(int key, int value) {
            this.value = value;
            this.key = key;
        }
        public DQ() {
        }
    }

    Map<Integer,DQ> map =  new HashMap<Integer,DQ>();
    int size ;
    int capacity ;
    DQ tail;
    DQ head;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        head = new DQ();
        tail = new DQ();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DQ dq = map.get(key);
        if (dq == null){
            return -1;
        }
        moveToHead(dq);
        return dq.value;
    }

    public void put(int key, int value) {
        DQ node = map.get(key);
        if (node == null) {
            DQ newNo = new DQ(key, value);
            addToHead(newNo);
            map.put(key,newNo);
            size++;
            if (size > capacity) {
                DQ dq2 = removeTail();
                map.remove(dq2.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void removeNode(DQ n){
        n.next.pre = n.pre;
        n.pre.next = n.next;
    }

    public void addToHead(DQ n){
        n.next = head.next;
        n.pre = head;
        head.next.pre = n;
        head.next = n;
    }

    public void moveToHead(DQ n){
        removeNode(n);
        addToHead(n);
    }


    public DQ removeTail(){
        DQ pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    public static void main(String[] args) {
        LRUCache3 lruCache3 = new LRUCache3(1);
        lruCache3.put(2,1);
        int i = lruCache3.get(2);
    }
}
