package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
* @Author: WYF
* @Description:有n个学生站成一排，
 * 每个学生有一个能力值，
 * 牛牛想从这n个学生中按照顺序选取k名学生，
 * 要求相邻两个学生的位置编号的差不超过d，
 * 使得这k个学生的能力值的乘积最大，你能返回最大的乘积吗？
* @Create: 2020/4/16 15:47
* @Version: 1.0
*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ai[] = new int[n];
        for (int i = 0; i < ai.length; i++) {
            ai[i] = input.nextInt();
        }
        int k = input.nextInt();
        int d = input.nextInt();


        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = ai[i];
        }
        for (int i = 1; i < k; i++) {
            int[] dp2 = new int[n];
            Arrays.fill(dp2, Integer.MIN_VALUE);
            for (int j = 0; j < n; j++) {
                if (j - d >= 0) {
                    for (int j2 = j - d; j2 < j; j2++) {
                        dp2[j] = Math.max(dp2[j], ai[j] * dp[j2]);
                    }
                } else {
                    for (int j2 = 0; j2 < j; j2++) {
                        dp2[j] = Math.max(dp2[j], ai[j] * dp[j2]);
                    }
                }
            }
            dp = dp2;
            System.out.println();
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
