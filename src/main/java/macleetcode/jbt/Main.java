package macleetcode.jbt;

import java.util.Scanner;

public class Main {
    static  int count = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        factor(i);
        System.out.println(count);
    }

    private static void factor(int i) {
        for (int j = 2 ; j < Math.sqrt(i); j++) {
            if (i%j == 0) {
                count++;
                i /= j;
                j--;
            }
        }
    }
}
