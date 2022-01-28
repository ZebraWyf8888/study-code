package macleetcode.by;

import java.util.ArrayList;

import java.util.List;

import java.util.*;

//https://blog.csdn.net/qq_31307013/article/details/80577135 dp 去求所有数字中 1个数

/**
 * n组括号的排列方式,递归
 */
public class a_28 {

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);

        System.out.println("请输入括号对数：");

        int n=reader.nextInt();

        int left=n,right=n;

        ArrayList<String> li=new ArrayList<String>();

        pattern("",left,right,li);

        for(String s:li){
            System.out.println(s);
        }

    }

    public static void pattern(String subset,int left,int right,ArrayList<String> re) {

        //成功的条件，找到了一种正确的形式

        if(left==0&&right==0)
        {
            re.add(subset);

        }
        //left<right subset+")"

        if(left<right)

        {
            pattern(subset+")",left,right-1,re);

        }

        //当left==right>0 subset+"("

        if(left>0)

            pattern(subset+"(",left-1,right,re);
    } }