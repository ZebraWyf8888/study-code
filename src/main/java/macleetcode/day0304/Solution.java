package macleetcode.day0304;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        int[] vec = new int[k];
        ArrayList<Integer> vec = new ArrayList<>();
        if (k == 0||k>input.length) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; ++i) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            Integer poll = queue.poll();
            vec.add(poll);
        }
        return vec;
    }
}
//
//class Solution.java {
//    public int[] smallestK(int[] arr, int k) {
//        int[] vec = new int[k];
//        if (k == 0) { // 排除 0 的情况
//            return vec;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer num1, Integer num2) {
//                return num2 - num1;
//            }
//        });
//        for (int i = 0; i < k; ++i) {
//            queue.offer(arr[i]);
//        }
//        for (int i = k; i < arr.length; ++i) {
//            if (queue.peek() > arr[i]) {
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; ++i) {
//            vec[i] = queue.poll();
//        }
//        return vec;
//    }
//}