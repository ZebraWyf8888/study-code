package ahot;

public class CountWays {
    public static int countWays(String s) {
        int mod = (int) (1e9 + 7);
        int n = s.length();
        int[][] dp = new int[n + 1][13];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 13; j++) {
                if (c == '?') {
                    for (int k = 0; k < 10; k++) {
                        dp[i][(j * 10 + k) % 13] += dp[i - 1][j];
                        dp[i][(j * 10 + k) % 13] %= mod;
                    }
                } else {
                    int digit = Character.getNumericValue(c);
                    dp[i][(j * 10 + digit) % 13] += dp[i - 1][j];
                    dp[i][(j * 10 + digit) % 13] %= mod;
                }
            }
        }

        return dp[n][5];
    }

    public static void main(String[] args) {
        String s = "1?2?3?";
        System.out.println(countWays(s)); // Output depends on the input
    }
}
