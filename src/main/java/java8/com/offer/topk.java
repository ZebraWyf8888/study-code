package java8.com.offer;

import java.util.ArrayList;

public class topk {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<>();
        }
        // 在数组中寻找位置为k - 1的pivot
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        // 收集这k个数
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= index; i++) {
            res.add(input[i]);
        }
        return res;
    }
    public static void quickSortCore(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(arr, lo, hi);
            quickSortCore(arr, lo, mid - 1);
            quickSortCore(arr, mid + 1, hi);
        }
    }
    public static int partition(int[] arr, int lo, int hi) {
        // 令arr[hi]为pivot
        // 将原数组分为小于pivot、pivot和大于等于pivot三部分
        swap(arr, lo + (int) Math.random() * (hi - lo + 1), hi);
        int small = lo - 1;
        while (lo < hi) {
            if (arr[lo] < arr[hi]) {
                swap(arr, ++small, lo++);
            } else {
                lo++;
            }
        }
        swap(arr, ++small, hi);

        return small;
    }

    /**
     * @Description: https://www.cnblogs.com/10158wsj/p/6782124.html
     * @Param: [a]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/29 13:14
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}