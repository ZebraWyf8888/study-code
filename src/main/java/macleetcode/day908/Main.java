package macleetcode.day908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] s = next.split(" ");
        boolean num = false;
        boolean big = false;
        boolean small = false;
        boolean else1 = false;
        for (int i = 0; i < s.length; i++) {
            String a = s[i];
            if (a.length() > 120 || a.length() < 8) {
                System.out.println(1);
            } else {
                char[] chars = a.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] <= 'Z' && chars[j] >= 'A') {
                        big = true;
                    } else if (chars[j] <= 'z' && chars[j] >= 'a') {
                        small = true;
                    } else if (chars[j] - '0' >= 0 && chars[j] - '0' <= 9) {
                        num = true;
                    } else {
                        else1 = true;
                    }

                }
                if (num && big && small && else1) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            }
            num = false;
            big = false;
            small = false;
            else1 = false;
        }
    }
}
