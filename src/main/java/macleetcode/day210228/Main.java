package macleetcode.day210228;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int target = Integer.parseInt(s2);
        String[] split = s1.split(" ");
        int[] ints = new int[s1.length()];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int j = 0; j < len; j++) {
            arr[j] = scanner.nextInt();
        }

        System.out.println(arr[len/2]);

    }
}
