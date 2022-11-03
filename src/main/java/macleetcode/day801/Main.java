package macleetcode.day801;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
//public class day806.mydata.Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int all = in.nextInt();
//        int shop = in.nextInt();
//        int[] w = new int[shop+1];
//        int[] v = new int[shop+1];
//        for (int i = 1; i <= shop; i++) {
//            w[i] = in.nextInt();
//            v[i] = in.nextInt();
//        }
//        int[][] dp = new int[shop+1][all+1];
//        for (int i = 1; i <= shop; i++) {
//            for (int j = 1; j <= all; j++) {
//                dp[i][j] = dp[i-1][j];
//                int nCount = j/w[i];
//                for (int k = 0; k <= nCount ; k++) {
//                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*w[i]]+ k*v[i]);
//                }
//            }
//        }
//
//        System.out.println(dp[shop][all]);
//    }
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int all = in.nextInt();
        int shop = in.nextInt();
        int[] w = new int[shop+1];
        int[] v = new int[shop+1];
        for (int i = 1; i <= shop; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        int[] dp = new int[all+1];
        for (int i = 1; i <= shop; i++) {
            for (int j = w[i]; j <= all; j++) {
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }

        System.out.println(dp[all]);
    }
}