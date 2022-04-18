package ahotreview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 */
public class TopKFrequent {
    /**
     * topk
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num: nums) {
            occurrences.put(num,occurrences.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> m[1] - n[1]);
        for (Map.Entry<Integer, Integer> entry:
             occurrences.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] <count ) {
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else {
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

}
