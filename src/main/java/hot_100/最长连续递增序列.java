package hot_100;

import java.util.Arrays;

/**
 * 最长连续递增序列
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/4 01:50
 */
public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // 创建一个dp一维数组，dp[i] 表示以 nums[i] 结尾的最长连续子序列的长度。
        int[] dp = new int[nums.length];
        // dp数组初始化：dp[i]所有元素初始值置为1，因为每个元素都至少可以单独成为子序列
        Arrays.fill(dp, 1);
        // 存储最大值，不断更新
        int res = dp[0];
        // 从下标为1开始往后遍历
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
