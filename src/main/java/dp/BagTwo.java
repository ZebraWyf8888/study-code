package dp;

import java.util.Scanner;

public class BagTwo {
    public static void main(String[] args) {
        int[] w = new int[]{0,1,2,3,4,5};
        int[] v = new int[]{0,3,5,7,9,2};
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] a = new int[x+1];
        for (int i = 1; i < 6; i++) {
            for (int j = x;j >= 0; j--){
                if (j >= w[i]) {
                    a[j] = a[j]>a[j-w[i]]+v[i]?a[j]:a[j-w[i]]+v[i];
                }
            }
        }
        System.out.println(a[x]);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
    }
}
