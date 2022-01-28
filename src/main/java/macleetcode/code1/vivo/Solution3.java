package macleetcode.code1.vivo;

import java.util.*;


public class Solution3 {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public static int solution (int n) {
        // write code here
        int a = resolve(n);
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        solution(22);
    }
    public static int resolve(int n){
        if(n<10)
        {
            return n;
        }
        for (int i = 9; i >1 ; --i) {
            if(n%i == 0)
            {
                return resolve(n/i)*10+i;
            }
        }
        return -1;
    }
}