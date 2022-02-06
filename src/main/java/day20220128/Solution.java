package day20220128;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /**
     * 我的
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            }
        };
        Arrays.sort(properties, comparator);

        int maxDef = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] >= maxDef) {
                maxDef = p[1];
            } else {
                ans++;
            }
        }
        return ans;
    }

    /**
     * leetcode 官方
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters2(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}