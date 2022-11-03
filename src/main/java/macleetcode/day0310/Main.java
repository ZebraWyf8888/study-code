package macleetcode.day0310;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[10];
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            int i1 = scanner.nextInt();
            a[i] = i1;
            sum += i1;
        }
        for (int i = 0; i < b.length; i++) {
            int i2 = scanner.nextInt();
            b[i] = i2;
            sum2 += i2;
        }
        double pow = Math.pow(sum, 2);
        int i = new Double(pow).intValue();
        System.out.println(i-sum2);


    }
}

//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int q = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < q; i++) {
//            int left = scanner.nextInt();
//            int right = scanner.nextInt();
//            if ((right-left) <2) {
//                System.out.println("NoScore");
//            }else {
//                int sum = 0;
//                int ans;
//                int max = Integer.MIN_VALUE;
//                int min = Integer.MAX_VALUE;
//                for (int j = left-1; j < right; j++) {
//                    sum += arr[j];
//                    max = Integer.max(max,arr[j] );
//                    min = Integer.min(min, arr[j]);
//                }
//                ans = (sum-max-min)/(right-(left-1)-2);
//                System.out.println(ans);
//            }
//        }
//    }
//}
