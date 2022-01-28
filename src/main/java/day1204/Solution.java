package day1204;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solve = solution.solve(2, 0, 2);
        System.out.println(solve);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回满足条件的最大的x。
     * @param a int整型 代表题意中的a
     * @param b int整型 代表题意中的b
     * @param n int整型 代表题意中的n
     * @return int整型
     */
    public int solve (int a, int b, int n) {
        // write code here
        if (n == 0) {
            return 0;
        }

        int y = n/a;
        int ans = y*a+b;
        while (ans>0){
            if (ans <= n) {
                return ans;
            }else {
                ans = ans-a;
            }
        }
        return ans;
    }

    /**
     *
     * @param k int整型 表示最多的操作次数
     * @param s string字符串 表示一个仅包含小写字母的字符串
     * @return int整型
     */
//    public int string2 (int k, String s) {
        // write code here
//
//    }
}
