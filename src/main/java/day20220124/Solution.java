package day20220124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1) {
            return intervals;
        }
        Comparator<int[]> comparator = (o1, o2) -> {
            if (o1.length < 1 || o2.length < 1) {
                return 0;
            }
            return o1[0] - o2[0];
        };
        Arrays.sort(intervals,comparator);

        ArrayList<int[]> ints = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int tempStart = intervals[i][0];
            int tempEnd = intervals[i][1];
            if (tempStart <= end){
                //两个区间重合
                end = Math.max(tempEnd,end);
            }else {
                int[] ans = new int[]{start,end};
                ints.add(ans);
                start = tempStart;
                end = tempEnd;
            }
        }
        int[] ans = new int[]{start,end};
        ints.add(ans);
        return ints.toArray(new int[ints.size()][]);
    }
}