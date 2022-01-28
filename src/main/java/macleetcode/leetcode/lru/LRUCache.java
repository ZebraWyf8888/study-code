package macleetcode.leetcode.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 方法1
 * 方法2：    //调用LinkedHashMap，传入参数 true 有序
 */
public class LRUCache {

    int capacity;

    LinkedHashMap<Integer,Integer> linkedHashMap ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap();
    }

    public int get(int key) {
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        //先删除，再放入新位置
        Integer value = linkedHashMap.remove(key);
        linkedHashMap.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
            return;
        }else {
            linkedHashMap.put(key,value);
            if (linkedHashMap.size()>capacity) {

                Set<Map.Entry<Integer, Integer>> entries = linkedHashMap.entrySet();
                Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();


                Map.Entry<Integer, Integer> next = iterator.next();

                linkedHashMap.remove(next.getKey());
            }
        }
    }
}
