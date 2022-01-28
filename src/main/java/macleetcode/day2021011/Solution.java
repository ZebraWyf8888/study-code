package macleetcode.day2021011;
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        //表示当前指针指向的丑数，下一个丑数==当前指针指向的丑数（dp[dp数组中的索引]）*对应的质因数(对应的质因数即2/3/5)
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for(int i = 2;i<=n;i++){
            int num2= dp[p2]*2;
            int num3= dp[p3]*3;
            int num5= dp[p5]*5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
        }
        return dp[n];
    }
}
