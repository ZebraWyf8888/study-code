package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和III
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/25 15:40
 */
public class 组合总和III {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return result;
    }

    private void backtracking(int k, int n, int startIndex) {
        // 递归终止的条件：path数组元素个数等于k，并且path数组中元素的总和等于n
        if (path.size() == k) {
            int sum = 0;
            for (int temp : path) {
                sum += temp;
            }
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.push(i);
            // 递归
            backtracking(k, n, i + 1);
            // 回溯（回溯的核心就是有加有减，递归前增加了什么，递归结束后就需要移除）
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new 组合总和III().combinationSum3(3, 7);
        System.out.println(lists);
    }
}

//class Solution.java {
//    /**
//     * 改进：把sum提取出来，方便剪枝
//     * @param k
//     * @param n
//     * @return
//     */
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        backtrackingII(k, n, 1,0, list, res);
//        return res;
//    }
//    public void backtrackingII(int k, int n, int startIndex, int sum, List<Integer> list, List<List<Integer>> res) {
//        // 递归终止的条件：list集合中的元素个数等于k时终止，并判断此时list集合中的元素之和是否等于n，是则添加到res集合中
//        if (list.size() == k) {
//            if (sum == n) {
//                List<Integer> temp = new ArrayList<>();
//                for (int i = 0; i < list.size(); i++) {
//                    temp.add(list.get(i));
//                }
//                res.add(temp);
//            }
//        }
//        for (int j = startIndex; j <= 9; j++) {
//            sum += j;
//            // 剪枝：如果总和sum已经大于n了，就直接退出for循环
//            if (sum > n) {
//                break;
//            }
//            list.add(j);
//            backtrackingII(k, n, j + 1, sum, list, res);
//            list.remove(list.size() - 1);
//            sum -= j;
//        }
//    }
//}
//
