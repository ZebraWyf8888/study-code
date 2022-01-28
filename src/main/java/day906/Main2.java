package day906;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A'&&chars[i]<='Z'){
                count++;
            }
        }
        System.out.println(Math.abs(chars.length/2-count));
    }
}
