package macleetcode.day712;

/**
 *https://leetcode-cn.com/problems/multiply-strings/
 * @author wangyifan
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length()+num2.length()];

        for (int i = num1.length()-1;i>=0;i--){
            /**
             * string char 等字符减去字符0（’0‘）就得到了，该字符的整形
             */
            int n1 = num1.charAt(i)-'0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                /**
                 * 从上一位取1或0，加上现在
                 */
                int sum = (res[i+j+1]+n1*n2);
                res[i+j+1] = sum%10;
                res[i+j] += sum /10;

            }
        }

        /**
         * 拼字符串
         */
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0&&res[i] ==0){
                continue;
            }
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        int n1 = '8' - '0';
        System.out.println(n1);
        Solution solution = new Solution();
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }
}
