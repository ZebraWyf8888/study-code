package day20220226;

public class Solution {
    /**
     * 爬楼梯、青蛙跳
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] num = new int[n + 1];
        return recursion(n,num);
    }

    private int recursion(int n,int[] num) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (num[n] > 0) {
            return num[n];
        }
        num[n] = recursion(n - 1,num) + recursion(n - 2,num);
        return num[n];
    }

    private int recursion2(int n, int[] memo) {
        if (n <= 2) {
            //memo[1], memo[2] 这两块空间也没有被使用。
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
        return memo[n];
    }


}
