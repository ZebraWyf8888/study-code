package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * 如果把子集问题、组合问题、分割问题都抽象为一棵树的话，
 * 那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/31 00:31
 */
public class 子集 {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        // 空集也是一个子集
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 这里可以不用写递归终止条件，因为当startIndex超过集合长度，for循环终止，也就退出递归了
        for (int i = startIndex; i < nums.length; i++) {
            path.push(nums[i]);
            result.add(new ArrayList<>(path));
            // 递归
            backtracking(nums, i + 1);
            // 回溯
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new 子集().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
