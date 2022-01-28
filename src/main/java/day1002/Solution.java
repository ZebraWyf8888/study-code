package day1002;

//最长回文

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
    public String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i+1 < n; i++) {
                int j = i+1;
                if (j == 0) {
                    dp[i][j] = true;
                }else if (j == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j))&&(dp[i+1][j-1]);
                }
                if (dp[i][j] && l+1>ans.length()) {
                    ans = s.substring(i,i+1+l );
                }
            }
        }
        return ans;
    }
}
