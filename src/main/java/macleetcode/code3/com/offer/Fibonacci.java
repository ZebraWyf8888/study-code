package macleetcode.code3.com.offer;

//https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3?answerType=1&f=discussion
//我自己用的应该和解题里面的大同小异，都是保留离目标最近的两个数

/**
 * 最好的一个版本，精髓在于one = sum - one 的获得one方式
 * 链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3?answerType=1&f=discussion
 * 来源：牛客网
 * <p>
 * public class Solution {
 * public int Fibonacci(int n) {
 * if(n == 0){
 * return 0;
 * }else if(n == 1){
 * return 1;
 * }
 * int sum = 1;
 * int one = 0;
 * for(int i=2;i<=n;i++){
 * sum = sum + one;
 * one = sum - one;
 * }
 * return sum;
 * }
 * }
 */
public class Fibonacci {
    public static int Fibonacci(int n) {
        int t1 = 1;
        int t2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            for (int i = 2; i < n; i++) {
                //就是1和2各执行一次，也可以改为boolean判断

                if (i % 2 != 0) {
                    t1 = t1 + t2;//1
                } else if (i % 2 == 0) {
                    t2 = t1 + t2;//2
                }
            }
            if (t2 > t1) {
                return t2;
            } else {
                return t1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
    }
}
