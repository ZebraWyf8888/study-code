package macleetcode.day916;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        char[] chars = next.toCharArray();

        int[] num = new int[26];

        for (int i = 0; i < num.length; i++) {
            num[i] = -1;
        }

        for (int i = 0; i < chars.length; i++) {
            num[chars[i]-'a']++;
        }
        int min =0;


        for (int i = 0; i < num.length; i++) {
            min = Math.min(num[i],min);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (num[chars[i]-'a'] == min) {
//                if (i == null) {
//
//                }else {
//
//                }
                stringBuilder.append(chars[i]);
            }
        }
        System.out.println(stringBuilder);


    }
}
