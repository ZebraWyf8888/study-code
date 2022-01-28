package macleetcode.day801;

import java.util.*;


public class Solution {
    public static void main(String[] args) {

    }
    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    public int reletive_7 (int[] digit) {
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            list.add(null);
        }
        // write code here
        return 0;
    }

    public static int count(int small,int big){
        int x1 = 1;
        for (int k = 0;k<small;k++){
            x1 = x1*big;
            big--;
        }
        int x2 = 1;

        for (int k = 0;small!=0;k++){
            x2 = x2*small;
            small--;
            if (small == 0){
                break;
            }
        }
        if (x2 == 0) {
            return 1;
        }
        return x1/x2;
    }
}