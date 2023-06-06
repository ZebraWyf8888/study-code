package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/29 23:43
 */
public class 全排列 {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backtracking(nums, used);
        return result;
    }

    /***
     *
     * @param used 排列不需要startIndex，但是需要使用一个used数组来标识数组中哪些元素被访问过了
     */
    private void backtracking(int[] nums, int[] used) {
        // 递归终止的条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                // 元素已被标识访问过了，则跳过
                continue;
            }
            used[i] = 1;
            path.push(nums[i]);
            // 递归
            backtracking(nums, used);
            // 回溯
            path.pop();
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new 全排列().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
