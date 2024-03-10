package ahot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 区间合并 {
    //56 区间合并
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        if (intervals == null || intervals.length == 0 ) return merged.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

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
}
