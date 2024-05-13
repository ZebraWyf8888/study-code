package macleetcode.code3;//import java.util.*;
//
//
//public class Solution.java {
//    /**
//     * 根据顾客属性计算出顾客排队顺序
//     * @param a int整型一维数组 顾客a属性
//     * @param b int整型一维数组 顾客b属性
//     * @return int整型一维数组
//     */
//    static int min = Integer.MIN_VALUE;
//    public static int[] WaitInLine (int[] a, int[] b) {
//        // write code here
//        int[][] ints = writeCodeHere(a, b);
//        int[] x = new int[a.length];
//        findQueen(ints,0,x);
//        System.out.println(min);
//        return null;
//    }
//
//    private static int[][] writeCodeHere(int[] a, int[] b) {
//        int length = a.length;
//        int[][] arr = new int[length][length];
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                arr[i][j] = a[j]*i+b[j]*(length-i-1);
//            }
//        }
//        return arr;
//    }
//
//    public static void main(String[] args) {
//        WaitInLine(new int[]{8,9,7},new int[]{5,8,3});
//    }
//
//    private static void findQueen(int[][] row,int i,int[] x) {
//        if (i == row.length) {
//            int temp = 0;
//            for (int j = 0; j < x.length; j++) {
//                temp += row[j][x[i]];
//            }
//            if (min > temp) {
//                min = temp;
//            }
//            return;
//        }
//        for (int j = 0; j < row.length; j++) {
//            if (i!=j) {
//                x[i] = j;
//                findQueen(row,i+1,x);
//                x[i] = 0;
//            }
//        }
//    }
//}
//
//import java.util.*;
//
//
//public class Solution.java {
//    /**
//     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
//     * @param R int整型
//     * @param N int整型 N进制
//     * @return int整型一维数组
//     */
//    public int[] GetPowerFactor (int R, int N) {
//        // write code here
//        int[] a;
//        int now = 0;
//        for (int i = 0; now > R; i++) {
//            now += Math.pow(R, i);
//        }
//        return a;
//    }
//}

import java.util.*;

//
//public class Solution.java {
//    /**
//     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
//     * @param R int整型
//     * @param N int整型 N进制
//     * @return int整型一维数组
//     */
//    public int[] GetPowerFactor (int R, int N) {
//        // write code here
//        int[] a;
//        int now = 0;
//        for (int i = 0; now > R; i++) {
//            now += Math.pow(N, i);
//            if (now == R) {
//                a = new int[i];
//            }
//        }
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i;
//        }
//        if (a == null) {
//            a = new int[5];
//        }
//        return a;
//    }
//}