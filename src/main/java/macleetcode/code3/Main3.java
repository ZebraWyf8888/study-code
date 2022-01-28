package macleetcode.code3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 问题描述
 * 　　﻿栈队列操作题。根据输入的操作命令，操作队列（1）入队、（2）出队并输出、（3）计算队中元素个数并输出。
 * 输入格式
 * 　　第一行一个数字N。
 * 　　下面N行，每行第一个数字为操作命令（1）入队、（2）出队并输出、（3）计算队中元素个数并输出。
 * 输出格式
 * 　　若干行每行显示一个2或3命令的输出结果。注意：2.出队命令可能会出现空队出队（下溢），请输出“no”，并退出。
 * 样例输入
 * 7
 * 1 19
 * 1 56
 * 2
 * 3
 * 2
 * 3
 * 2
 * 样例输出
 * 19
 * 1
 * 56
 * 0
 * no
 * 数据规模和约定
 * 　　1<=N<=50
 */
public class Main3 {
    static LinkedList<Integer> arrayList = new LinkedList<Integer>();//模拟队列
    static LinkedList arrayList2 = new LinkedList();//模拟输出

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            if (a == 1) {
                int num = scanner.nextInt();
                in(num);
            } else if (a == 2) {
                Integer out = out();
                if (out ==null){
                    arrayList2.add("no");
                }else {
                    arrayList2.add(out);
                }
            } else if (a == 3) {
                arrayList2.add(arrayList.size());
            }

        }

        for (Object n : arrayList2) {
            System.out.println(n);
        }

    }
    private static void in(int num) {
        arrayList.add(num);
    }

    private static Integer out() {
        if (arrayList.isEmpty()){
            return null;
        }
        Integer remove = arrayList.remove();
        return remove;
    }
}


