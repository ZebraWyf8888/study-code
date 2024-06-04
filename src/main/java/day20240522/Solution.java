package day20240522;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // 记录所有key的失败次数
        HashMap<Integer, Integer> menberToTims = new HashMap<>();
        for (int[] item : matches) {
            if (!menberToTims.containsKey(item[0])) {
                menberToTims.put(item[0], 0);
            }
        }

        for (int[] item : matches) {
            int lossTime = menberToTims.getOrDefault(item[1], 0);

            menberToTims.put(item[1],lossTime +1);
        }


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansAllSuccess = new ArrayList<>();
        List<Integer> onlyOneLose = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : menberToTims.entrySet()) {
            if (entry.getValue() == 1) {
                onlyOneLose.add(entry.getKey());
            } else if (entry.getValue() == 0) {
                ansAllSuccess.add(entry.getKey());
            }
        }
        ansAllSuccess.sort(Integer::compareTo);
        onlyOneLose.sort(Integer::compareTo);
        ans.add(ansAllSuccess);
        ans.add(onlyOneLose);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //[[1,5],[2,5],[2,8],[2,9],[3,8],[4,7],[4,9],[5,7],[6,8]]
        List<List<Integer>> winners = solution.findWinners(new int[][]{{1, 5}, {2, 5}, {2, 8}, {2, 9}, {3, 8}, {4, 7}, {4, 9}, {5, 7}, {6, 8}});

//        List<List<Integer>> winners = solution.findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
        System.out.println(winners);

    }
}