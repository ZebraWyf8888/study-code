package day20220228;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class DQ{
        DQ pre;
        DQ next;
        int value;
        int key;
        public DQ(){

        }
        public DQ(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer,DQ> map =  new HashMap<Integer,DQ>();
    int size ;
    int capacity ;
    DQ tail;
    DQ head;

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

    public Solution(int capacity) {
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
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        Solution solution = new Solution(k);
        ArrayList<Integer> list=new ArrayList<Integer>();

        for(int [] arr: operators){
            if (arr[0] == 1) {
                solution.put(arr[1],arr[2]);
            }else {
                int i = solution.get(arr[1]);
                list.add(i);
            }
        }


        Integer[] integers = list.toArray(new Integer[list.size()]);
        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();

    }
}