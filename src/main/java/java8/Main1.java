package java8; /**
 问题描述
 　　给定L,R。统计[L,R]区间内的所有数在二进制下包含的“1”的个数之和。
 　　如5的二进制为101，包含2个“1”。
 输入格式
 　　第一行包含2个数L,R
 输出格式
 　　一个数S，表示[L,R]区间内的所有数在二进制下包含的“1”的个数之和。
 样例输入
 2 3
 样例输出
 3
 数据规模和约定
 　　L<=R<=100000;
*/
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int all = 0;
        for (int i = n; i <= m ; i++) {
            all += NumberOf12(i);
        }
        System.out.println(all);
    }

    //升级版本的解法
    //把一个是数字-1都是把原来那个数字的最右边的1变成0
    //基于上面这句话再让 原来那个数字与他减去一之后的数字做与运算，得到的结果就是
    //最左边的1变0，其他数字不变
    public static int NumberOf12(int n) {
        int count = 0;
        while (n!=0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}