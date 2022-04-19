package day20220419;

import java.util.Arrays;

public class Solution {
    /**
     * 821. 字符的最短距离
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        char[] charArray = s.toCharArray();

        int[] ans = new int[length];
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (c == charArray[i]) {
                temp = 0;
                ans[i] = temp;
                temp++;
            }else if (temp<Integer.MAX_VALUE) {
                ans[i] = temp;
                temp++;
            }else {
                ans[i] = temp;
            }
        }
        temp = Integer.MAX_VALUE;
        for (int i = length-1; i >= 0; i--) {
            if (c == charArray[i]) {
                temp = 0;
                ans[i] = Math.min(temp,ans[i]);
                temp++;
            }else if (temp<Integer.MAX_VALUE) {
                ans[i] = Math.min(temp,ans[i]);
                temp++;
            }else {
                ans[i] = Math.min(temp,ans[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        s = "", c = "e"
        int[] ints = solution.shortestToChar("loveleetcode", 'e');
        //[3,2,1,0,1,0,0,1,2,2,1,0]
        System.out.println(Arrays.toString(ints));

    }
}
