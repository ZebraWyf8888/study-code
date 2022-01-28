package macleetcode.day1117;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] allCellsDistOrder(int R , int C,int ro,int co){
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i*C + j] = new int[]{i,j};
            }
        }

        Arrays.sort(ret, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0]-ro) + Math.abs(a[1] - co)) - (Math.abs(b[0]-ro)+Math.abs(b[1]-co));
            }
        });
                return ret;
    }

    public static int maxSubArray(int[] nums) {
        int nowTemp = nums[0];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nowTemp = nums[i];
            if (nowTemp > maxValue) {
                maxValue = nowTemp;
            }
            for (int j = i+1; j < nums.length; j++) {
                nowTemp += nums[j];
                if (nowTemp > maxValue) {
                    maxValue = nowTemp;
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = new int[]{-1,-2};
        int i = maxSubArray(arr2);
        System.out.println(i);

    }
}
