package day906;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] ints = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
            count = count ^ints[i];
        }
        int ans = 0;
        if (count%2 == 0) {
            ans =1;
        }
        System.out.println(ans);

    }
}
