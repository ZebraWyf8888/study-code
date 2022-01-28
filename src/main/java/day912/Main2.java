package day912;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bignum = scanner.nextInt();
        for (int i = 0; i < bignum; i++) {

            HashSet<Integer> objects = new HashSet<>();
            
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            for (int j = 0; j < m; j++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int moneyk = scanner.nextInt();
                if (moneyk <= k) {
                    objects.add(A);
                    objects.add(B);
                }
            }
            if (objects.size()==n) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

}
