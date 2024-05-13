package ahot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * topk
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> m[1] - n[1]);
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


    public static int findKthLargest(int[] nums, int k) {


        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<Integer> queue = new PriorityQueue<>((m, n) -> m - n);
        for (int count : nums) {

            if (queue.size() == k) {
                if (queue.peek() < count) {
                    queue.poll();
                    queue.offer(count);
                }
            } else {
                queue.offer(count);
            }
        }
//        int ret = 0;
//        for (int i = 0; i < k; ++i) {
//            ret =
//        }
        return queue.poll();

    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        // 测试用例1：普通情况
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("数组：" + Arrays.toString(nums1) + "，第 " + k1 + " 大的数是：" + solution.findKthLargest(nums1, k1));

        // 测试用例2：包含负数
        int[] nums2 = {-1, 2, 0, 3, 5};
        int k2 = 3;
        System.out.println("数组：" + Arrays.toString(nums2) + "，第 " + k2 + " 大的数是：" + solution.findKthLargest(nums2, k2));

        // 测试用例3：包含重复元素
        int[] nums3 = {4, 2, 4, 1, 5, 4};
        int k3 = 1;
        System.out.println("数组：" + Arrays.toString(nums3) + "，第 " + k3 + " 大的数是：" + solution.findKthLargest(nums3, k3));
    }
}
