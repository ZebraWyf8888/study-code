package java8.day829;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] split = next.split("_");


        int t = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i] != null&&split[i].length()>0) {
                if (t == 0) {
                    System.out.print(split[i]);
                    t=1;
                }else {
                    System.out.print("_"+split[i]);
                }

            }
        }
    }
}
