package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @version 2.0.0
 * @date 2023/3/25 16:28
 */
public class 电话号码的字母组合 {

    // 存放最终的结果集
    List<String> res = new ArrayList<>();
    // 存放临时结果集
    StringBuilder sb = new StringBuilder();

    // 数字和字母的映射：数字i代表的字母对应numbers[i]（题目说字符串只包含2-9，因此可以不考虑其他特殊情况）
    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtracking(digits, 0);
        return res;
    }

    /***
     * @param index index代表当前要处理的是第几个数，即digits字符串的哪个下标
     *
     * 这道题目和组合的最大区别是：
     * 组合题目每层for循环都是使用同一个集合，因此通过startIndex标识每一层for循环应该从该集合的哪个位置开始遍历
     * 而本题目是每层for循环使用的是不同的集合，因此通过index来标识当前应该处理的是哪个集合
     *
     */
    private void backtracking(String digits, int index) {
        // 递归终止的条件：当index的值等于字符串digits的长度，代表已经处理到最后一个数来
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        // 获取到下标为index的具体数字
        int temp = digits.charAt(index) - '0';
        String array = numbers[temp];
        for (int i = 0; i < array.length(); i++) {
            sb.append(array.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new 电话号码的字母组合().letterCombinations("33");
        System.out.println(list);
    }
}
