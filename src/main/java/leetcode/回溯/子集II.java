package leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集II
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/31 00:31
 */
public class 子集II {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 去重需要先对数组进行排序
        Arrays.sort(nums);
        backtracking(nums, 0);
        // 空集也是一个子集
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 这里可以不用写递归终止条件，因为当startIndex超过集合长度，for循环终止，也就退出递归了
        for (int i = startIndex; i < nums.length; i++) {
            // 注意这里判断条件是i > startIndex，而不是i > 0;加上这个限制条件限制了每一层访问第一个元素都不会被跳过
            if (i > startIndex && nums[i] == nums[i - 1]) {
                // 同一层重复元素会跳过
                continue;
            }
            path.push(nums[i]);
            result.add(new ArrayList<>(path));
            // 递归
            backtracking(nums, i + 1);
            // 回溯
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new 子集II().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(subsets);
    }
}
