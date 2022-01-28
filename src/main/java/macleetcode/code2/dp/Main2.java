package macleetcode.code2.dp;


//动态规划，dp[i][j]代表选i+1个人并以第j个人为结束时最大的乘积
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ai[] = new int[n];
        for (int i = 0; i < ai.length; i++) {
            ai[i] = input.nextInt();
        }
        int k = input.nextInt();
        int d = input.nextInt();

        int dp[][] = new int[k][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = ai[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=Integer.MIN_VALUE;
                if (j - d >= 0) {
                    for (int j2 = j - d; j2 < j; j2++) {
                        dp[i][j] = Math.max(dp[i][j], ai[j] * dp[i - 1][j2]);
                    }
                } else {
                    for (int j2 = 0; j2 < j; j2++) {
                        dp[i][j] = Math.max(dp[i][j], ai[j] * dp[i - 1][j2]);
                    }
                }
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[k - 1][i]);
        }
        System.out.println(res);
    }
}