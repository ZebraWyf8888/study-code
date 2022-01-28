package day906;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int[] ints = new int[i];
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                ints[j] = scanner.nextInt();
                if (ints[j]%2==0) {
                    flag = false;
                }
            }
            if (flag&&(i%2!=0)) {
                boolean flag2 = isRight(ints);
                if (flag2 == true) {
                    System.out.println("YES");
                }
                System.out.println("NO");
            }else {
                System.out.println("NO");
            }
        }

    }

    private static boolean isRight(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                continue;
            }

        }
        return true;
    }
}
