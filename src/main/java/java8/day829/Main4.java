package java8.day829;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        fun(i,2);
    }

    private static void fun(int i, int two) {
        while (i%two!=0&&two<i){
            two++;
        }
        if (two < i) {
            System.out.print(two+"*");
            fun(i/two, 2);
        }else {
            System.out.print(i);
        }
    }
}