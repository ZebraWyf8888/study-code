package macleetcode.leetcode.lru;

import java.util.HashMap;
import java.util.Map;
//
//public class LruCache2 {
//    private class ListNode{
//        int key;
//        int val;
//        ListNode pre;
//        ListNode next;
//        public ListNode(int key,int val){
//            this.key = key;
//            this.val = val;
//            pre = null;
//            next = null;
//        }
//    }
//    private int capacity;
//    private Map<Integer,ListNode> map;
//    private ListNode head;
//    private ListNode tail;
//    public LruCache2(int capacity){
//        this.capacity = capacity;
//        map = new HashMap<>();
//        head.next = tail;
//        tail.pre = head;
//    }
//    public int get(int key){
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        ListNode node = map.get(key);
//        node.next.pre = node.pre;
//        node.pre.next = node.next;
//        moveToTail(node);
//        return node.val;
//    }
//      public void put(int key, int value) {
//        //直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
//        if (get(key) != -1) {
//            map.get(key).val = value;
//            return;
//        }
//        //不存在，new一个出来,如果超出容量，把头去掉
//        ListNode node = new ListNode(key, value);
//        map.put(key, node);
//        moveToTail(node);
//
//        if (map.size() > capacity) {
//            map.remove(head.next.key);
//            head.next = head.next.next;
//            head.next.pre = head;
//        }
//    }
//
//    private void moveToTail(ListNode node) {
//        node.pre = tail.pre;
//        tail.pre = node;
//        node.pre.next = node;
//        node.next = tail;
//    }
//}

//写法修改
class LruCache2 {

    // 定义一个双向链表
    static class Node {
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Node pre;
        Node next;
    }

    // 用来快速定位节点和记录节点数量
    private HashMap<Integer, Node> map;
    // 虚拟头节点
    private Node dummyFirst;
    // 虚拟尾节点
    private Node dummyLast;
    // LRU的容量
    private int capacity;

    /**
     * 初始化方法
     * @param capacity 指定缓存的容量
     */
    public LruCache2(int capacity) {
        map = new HashMap<>(capacity);
        dummyFirst = new Node(-1, -1);
        dummyLast = new Node(-1, -1);
        // 建立虚拟头和虚拟尾节点的关系
        dummyFirst.next = dummyLast;
        dummyLast.pre = dummyFirst;
        this.capacity = capacity;
    }

    /**
     * 从缓存中获取数据
     * @param key 缓存的键
     * @return 缓存的值
     */
    public int get(int key) {
        // 如果map中没有这个key,证明没有命中缓存,直接返回-1即可
        if (!map.containsKey(key)) {
            return -1;
        }
        Node target = map.get(key);
        // 将命中缓存的节点移到链表的最末尾（虚拟尾节点前面）
        moveToTail(target, false);
        return target.value;
    }

    /**
     * 向缓存中写入数据
     * @param key 写入的键
     * @param value 写入的值
     */
    public void put(int key, int value) {
        // 如果这个map存在的话,只需要把这个节点移到链表的最末尾（虚拟尾节点前面）,并修改链表的值即可
        if (map.containsKey(key)) {
            moveToTail(map.get(key), false);
            map.get(key).value = value;
            return;
        }
        // 如果map不存在的话,需要在map和链表的最末尾（虚拟尾节点前面）新增这个节点,并且检查现在缓存超没超容量,如果超了的话需要删除链表的最前面的节点(虚拟头节点的后面)
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node, true);
        while (map.size() > capacity) {
            map.remove(dummyFirst.next.key);
            dummyFirst.next = dummyFirst.next.next;
            dummyFirst.next.pre = dummyFirst;
        }
    }

    /**
     * 将节点移动至链表的末尾，假末尾节点前面
     */
    private void moveToTail(Node node, boolean insert) {
        // 如果不是新增,而是修改,我们要维护原节点的pre和next节点的next和pre引用
        if (!insert) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 将节点移动到链表的最末尾（虚拟尾节点前面）
        node.next = dummyLast;
        node.pre = dummyLast.pre;
        dummyLast.pre = node;
        node.pre.next = node;
    }
}