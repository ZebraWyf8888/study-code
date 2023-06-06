package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/27 23:47
 */
public class 组合总和 {
    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtracking(candidates, target, 0, 0);
        return result;
    }

    /***
     * @param startIndex 代表每次for循环从哪个位置开始遍历
     *                   通常来说，如果是一个集合来求组合的话，就需要startIndex
     */
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
            // 剪枝优化：对集合进行排序，如果 sum + candidates[i] > target 就终止for循环遍历
            // 在求和问题中，排序之后加剪枝是常见的套路！
            if (sum + candidates[i] > target) {
                break;
            }
            path.push(candidates[i]);
            sum += candidates[i];
            // 递归，注意这里startIndex不需要+1，因为同一个数字可以无限制重复被选取
            backtracking(candidates, target, sum, i);
            // 回溯
            path.pop();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> lists = new 组合总和().combinationSum(arr, 7);
        System.out.println(lists);
    }
}
