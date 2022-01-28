package java8.day829;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] split = next.split(",");
        int kuang = Integer.parseInt(split[0]);
        int chang = Integer.parseInt(split[1]);
        int[][] ints = new int[kuang][chang];
//        int[] kuangshort = new int[kuang];
//        int[] changshort = new int[chang];

        for (int i = 0; i < kuang; i++) {
            for (int j = 0; j < chang; j++) {
                int anInt = sc.nextInt();
                ints[i][j] = anInt;
//                kuangshort[i] += anInt;
//                changshort[j] += anInt;
            }
        }



        long[] dp = new long[chang];
        dp[0] = ints[0][0];

        for (int i = 1; i < chang; i++) {
            dp[i] = dp[i-1]+ints[0][i];
        }
        for (int i = 1; i < kuang; i++) {
            for (int j = 1; j < chang; j++) {
                dp[j] = Math.max(dp[j],dp[j-1])+ints[i][j];
            }
        }

        if (chang == 1) {
            for (int i = 1; i < kuang; i++) {
                dp[chang-1] += ints[i][0];
            }
        }
        System.out.println(dp[chang-1]);
    }
}

//作者：apple_cook
//        链接：https://www.nowcoder.com/discuss/492921?type=0&order=3&pos=6&page=0&channel=-2&source_id=discuss_center_0
//        来源：牛客网
//        import java.util.Scanner;

/**
 * 边缘没用设置
 */
 class Keda1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] nums = line.split(",");
        int n = Integer.valueOf(nums[0]);
        int m = Integer.valueOf(nums[1]);
        int[][] pan = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] stmp = input.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                pan[i][j] = Integer.valueOf(stmp[j]);
            }
        }
        int[][] ans = pan;
        for (int i = 1; i < m; i++) {
            ans[0][i] = ans[0][i] + ans[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            ans[i][0] = ans[i][0] + ans[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]) + ans[i][j];
            }
        }
        System.out.println(ans[n - 1][m - 1]);
    }
}
