package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列II
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/29 23:55
 */
public class 全排列II {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        // 对数组进行排序，才方便通过相邻的节点来判断是否重复
        Arrays.sort(nums);
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
            // 这里需要记住判断条件不能少了used[i - 1] == 0
            // 这里不太好理解，需要用一组数代入方便理解 [1,1,1,2]
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                // 重复的元素则跳过不处理
                continue;
            }
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
        List<List<Integer>> permute = new 全排列II().permuteUnique(new int[]{1,2,1});
        System.out.println(permute);
    }
}
