package leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/14 00:57
 */
public class 组合 {

    // 存放最终的结果集
    List<List<Integer>> result = new ArrayList<>();
    // 存放临时结果集
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /***
     * @param startIndex 代表每次for循环从哪个位置开始遍历
     */
    private void backtracking(int n, int k, int startIndex) {
        // 递归终止的条件：path数组元素个数等于k，说明到达叶子节点
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.push(i);
            // 递归
            backtracking(n, k, i + 1);
            // 回溯（回溯的核心就是有加有减，递归前增加了什么，递归结束后就需要移除）
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new 组合().combine(4, 2);
        System.out.println(combine);
    }
}

//class Solution.java {
//    public List<List<Integer>> combine(int n, int k) {
//        LinkedList<Integer> stack = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        backtracking1(n, k, 1, stack, res);
//        return res;
//    }
//    /**
//     *
//     * @param n
//     * @param k
//     * @param startIndex：代表每次for循环的子集起始下标
//     * @param stack：保存中间结果，利用栈先进后出的特性，方便回溯
//     * @param res：结果列表
//     */
//    public void backtracking1(int n, int k, int startIndex, LinkedList<Integer> stack, List<List<Integer>> res) {
//        // 递归结束的条件
//        if (stack.size() == k) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < stack.size(); i++) {
//                list.add(0,stack.get(i));
//            }
//            res.add(list);
//            return;
//        }
//        for (int i = startIndex; i <= n; i++) {
//            // 还需要的元素个数
//            int x = k - stack.size();
//            // for循环选择的起始位置之后的元素个数
//            int y = n - startIndex + 1;
//            // 剪枝
//            if (y < x) {
//                break;
//            }
//            // 递归前的操作
//            stack.push(i);
//            // 递归
//            backtracking1(n, k, i + 1, stack, res);
//            // 回溯操作：递归前的逆操作
//            stack.pop();
//        }
//    }
//}