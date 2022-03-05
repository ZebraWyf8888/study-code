package day20220208;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * subarraySum      请你统计并返回该数组中和为 k 的连续子数组的个数。
 * subarraySumMin   返回那个数组，要求他最短
 */
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static int[] subarraySumMin(int[] nums, int k) {
        int pre = 0;
        /**
         * key ：前缀和，value：索引
         */
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int[] ans = null;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                Integer integer = mp.get(pre - k);
                if (ans == null || i - integer < ans.length) {
                    ans = Arrays.copyOfRange(nums, integer + 1, i + 1);
                }
               /* for (int j = integer+1; j <= i; j++) {
                    System.out.print(nums[j] + "+");
                }
                System.out.println();*/
            }
            mp.put(pre, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubArraySum solution = new SubArraySum();
        int[] ints = SubArraySum.subarraySumMin(new int[]{1, 2, 2, 1, 3, 1,2}, 6);
        printArray(ints);
    }

    //打印数组方法
    public static void printArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();
    }
}
