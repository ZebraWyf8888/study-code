package note.vivo;

import java.util.*;


public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n int整型 n>9
     * @return int整型
     */
    public static int solution(int n) {
        // write code here
        for (int i = 1; i < 10; i++) {
            int a = n / i;
            if (a < 10 && n % i == 0) {
                return a < i ? a * 10 + i : i * 10 + a;
            }
        }
        for (int i = 1; i < 10; i++) {
            int a = n / i;
            for (int j = 1; j < 10; j++) {
                int b = a / j;
                if (b < 10 && a % j == 0) {
                    return i * 100 + (b < j ? b * 10 + j : j * 10 + b);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solution(108));
    }

    /**
     * @Author: WYF
     * @Description: find 1
     * @Create: 2020/3/31 22:02
     * @Version: 1.0
     */
    long CountOne_simple(long n) {
        long i = 0, j = 1;
        long count = 0;
        for (i = 0; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % 10 == 1) {
                    count++;
                }
                j = j / 10;
            }
        }
        return count;
    }

}