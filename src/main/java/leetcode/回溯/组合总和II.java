package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和II
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/28 00:24
 */
public class 组合总和II {
    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序；同时，排序也是为了方便后续剪枝操作
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        // 递归终止的条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // 符合条件
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > startIndex && candidates[i] == candidates [i - 1]) {
                continue;
            }
            // 剪枝优化：对集合进行排序，如果 sum + candidates[i] > target 就终止for循环遍历
            // 在求和问题中，排序之后加剪枝是常见的套路！
            if (sum + candidates[i] > target) {
                break;
            }
            path.push(candidates[i]);
            sum += candidates[i];
            // 递归，注意这里startIndex需要+1，因为同一个数字不可以被重复被选取
            backtracking(candidates, target, sum, i + 1);
            // 回溯
            path.pop();
            sum -= candidates[i];
        }
    }
}
