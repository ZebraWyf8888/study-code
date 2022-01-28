package macleetcode.day822;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("True");
    }
}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int i = in.nextInt();
//        String[] test = new String[i];
//        for (int j = 0; j < i; j++) {
//            test[j] = in.next();
//        }
//        int count = 0;
//
//        for (int j = 0; j < i; j++) {
//            String s = test[j];
//            if (s.length()>10) {
//                continue;
//            }
//            char[] chars = s.toCharArray();
//            int time = 0;
//            for (int k = 0; k < chars.length; k++) {
//                if (!(('a'<= chars[k]&&chars[k]<= 'z')||('A'<= chars[k]&&chars[k]<= 'Z'))) {
//                    break;
//                }
//                time = time+1;
//            }
//            if (time != chars.length) {
//                continue;
//            }
//            count++;
//        }
//        System.out.println(count);
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int M = in.nextInt();
//        int[] arr = new int[N];
//        for (int i = 1; i <= N; i++) {
//            arr[i] = i;
//        }
//
//        int[] doth = new int[M];
//        for (int i = 0; i < M; i++) {
//            doth[i] = in.nextInt();
//            if (doth[i] == 1) {
//                arr = first(arr);
//            }
//            if (doth[i] == 2) {
//                arr = second(arr);
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i] + " ");
//        }
//
//    }
//
//    private static int[] first(int[] arr) {
//        int start = arr[0];
//        for (int i = 0; i < arr.length-1; i++) {
//            arr[i] = arr[i+1];
//        }
//        arr[arr.length-1] = start;
//        return arr;
//    }
//
//    private static int[] second(int[] arr) {
//        for (int i = 0; i < arr.length; i +=2) {
//            int i1 = arr[i];
//            int i2 = arr[i + 1];
//            arr[i] = i2;
//            arr[i+1] = i1;
//        }
//        return arr;
//    }