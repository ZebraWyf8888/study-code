package ahot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 区间合并 {
    //56 区间合并
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return merged.toArray(new int[0][]);
        // 对起点终点进行排序
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        quickSortV2(intervals, 0, intervals.length - 1);
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }

    public static void quickSortV2(int[][] nums, int low, int high) {
        int i = low;
        int j = high;

        if (i > j) {
            return;
        }
        while (i < j) {
            while (i < j && nums[j][0] >= nums[low][0]) {
                j--;
            }
            while (i < j && nums[i][0] <= nums[low][0]) {
                i++;
            }

            if (i < j) {
                int[] temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        int[] temp = nums[low];
        nums[low] = nums[i];
        nums[i] = temp;


        quickSortV2(nums, low, i - 1);
        quickSortV2(nums, i + 1, high);
    }

    public static void main(String[] args) {
        int[][] nums = {new int[]{2}, new int[]{3}, new int[]{5}, new int[]{7}, new int[]{-5}, new int[]{0}, new int[]{1}};
        quickSortV2(nums, 0, nums.length - 1);
        System.out.println(Arrays.deepToString(nums));
    }
}
