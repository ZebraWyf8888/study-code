package dp;

public class FindTarget {
    static int count;


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 1, 1};
        int targetSumWays2 = findTargetSumWays2(a, 3);
        System.out.println(targetSumWays2);
    }

    ///动态规划，无非就是一个矩阵 两个for 一个if
    private static int findTargetSumWays2(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0]+1000] = 1;
        dp[-nums[0]+1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum= -1000;sum<=1000; sum++) {
                if (dp[sum+1000]>0) {
                    next[sum+1000+nums[i]] += dp[sum+1000];
                    next[sum+1000-nums[i]] += dp[sum+1000];
                }
            }
            dp = next;
        }
        return S>1000?0:dp[S+1000];
    }

    /**
     * @Description: 方法1，递归遍历所有
     * @Param: [nums, S]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/4/12 20:30
    */
    public static int findTargetSumWays(int[] nums, int S) {
        find(nums, S, 0, 0);
        System.out.println(count);
        return count;
    }

    /**
     * @Description: 递归找
     * @Param: nums:数字
     * @Param: target:目标值
     * @Param: i:第几个数
     * @Param: now:当前的值
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/12 18:49
     */
    private static void find(int[] nums, int target, int i, int now) {
        if (i == nums.length) {
            if (now == target) {
                count++;
            }
        } else {
            find(nums, target, i + 1, now + nums[i]);
            find(nums, target, i + 1, now - nums[i]);

        }
    }
}
