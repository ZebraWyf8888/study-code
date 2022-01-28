package day906;

import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] A = new int[p];
        int[] B = new int[q];
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < p; i++) {
            A[i] = scanner.nextInt();
            set.add(A[i]);
        }
        for (int i = 0; i < q; i++) {
            B[i] = scanner.nextInt();
            if (set.contains(B[i])) {
                count++;
            }else {
                set.add(B[i]);
            }
        }
        int i = p - count;
        int j = q - count;

        System.out.println(i +" "+ j +" "+count);

    }
}
