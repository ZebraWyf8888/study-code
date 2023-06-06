package hot_100;

/**
 * [7,1,5,3,6,4]
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2022/8/17 22:13
 */
public class 买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        // dp[i]代表第i天的最大利润
        int[] dp = new int[prices.length];
        // dp数组初始化，由于股票买入和卖出不能在同一天，因此第0天利润肯定为0
        dp[0] = 0;
        // min代表股票价格最小值，初始化为第0天的价格
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 状态方程：第i天的最大利润为i-1天的最大利润和第i天的股票价格与min的差之间的最大值
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            // 更新最小值，这一步放在状态方程前执行也可以
            min = Math.min(min, prices[i]);
        }
        // 打印dp数组，验证是否符合预期
        // System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
