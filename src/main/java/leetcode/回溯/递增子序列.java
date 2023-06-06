package leetcode.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 递增子序列
 *
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/31 01:06
 */
public class 递增子序列 {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 这里可以不用写递归终止条件，因为当startIndex超过集合长度，for循环终止，也就退出递归了

        // 由于本题求自增子序列，是不能对原数组经行排序的，排完序的数组都是自增子序列了
        // 使用set集合去重：如果某个元素已经在本层出现过了，直接跳过
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                // 同一层重复元素会跳过
                continue;
            }
            set.add(nums[i]);
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                // 当前元素值需要大于等于path列表最后一个元素，才满足递增的条件
                continue;
            }
            // 注意本题目path列表不能使用栈的方式操作数据，会导致结果不满足递增的条件
            path.add(nums[i]);
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }
            // 递归
            backtracking(nums, i + 1);
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new 递增子序列().findSubsequences(new int[]{4,7,6,7});
        System.out.println(subsets);
    }
}
