package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * s = "leetcode", wordDict = ["leet", "code"]
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2022/8/20 01:43
 */
public class 单词拆分 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 代表字符串的前i个字符组成的子串是否能在字典中找到，即s(0,i-1)
        // 假设s="apple"，那么dp[1]代表"a"是否能在字典中找到，dp[5]代表"apple"是否能在字典中找到
        boolean[] dp = new boolean[s.length() + 1];
        // dp数组初始化：
        dp[0] = true;
        // 状态转移方程
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                // 理解递推公式：例如当前s为"leetcode"，dp[4]为true代表的是子串"leet"可以在字典中找到
                // 当新增一个字符c时，此时要判断的是子串"leetc"是否在字典中，
                // 先看leet是否能在字典中找到（dp[4]）且c能否在字典中找到，
                // 如果不能，再继续看lee是否能在字典中找到（dp[3]）且tc能否在字典中找到，
                // 一直往下找，直到找到一个符合的，则dp[5]为true，否则为false
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }
}
