package macleetcode.by;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution1 {
    public int coinChange(int[] coins,int amount){
        int max = amount +1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <i) {
                    dp[i] = Math.max(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,5, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        return dp[amount] > amount ? -1:dp[amount];

    }
}
