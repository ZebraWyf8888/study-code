package macleetcode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {
        int sum = 0;
        for (int i = 0; i < packets.length; i++) {
            sum +=packets[i];
        }
        int i = sum / (n + 1);
        return i;
    }

    /******************************结束写代码******************************/

//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        int[] packets = stringToIntegerArray(in.nextLine().trim());
//        int n = Integer.parseInt(in.nextLine().trim());
//
//        int res = maxAmount(packets, n);
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1;i<n+1;i++) {
            int temp = i;
            boolean ishash =false;
            while(temp>0){
                if(temp %10 == 4 || temp%10 == 7){
                    ishash  = true;
                    break;
                }
                temp = temp/10;
            }
            if(!ishash){
                count ++;
            }
        }
        System.out.println (count);

    }
    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }
}
