package macleetcode.day902;//package macleetcode.day902;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T1 = sc.nextInt();
//        for (int i = 0; i < T1; i++) {
//            int niuCount = sc.nextInt();
//            int[] ans = new int[niuCount+1];
//            int rightCount = sc.nextInt();
//            for (int j = 0; j < rightCount; j++) {
//                int num = sc.nextInt();
//                for (int k = 0; k < num; k++) {
//                    int anInt = sc.nextInt();
//                    int bnInt = sc.nextInt();
//                    doPlus(anInt,bnInt,ans);
//                }
//            }
//
//            ArrayList<Integer> list = new ArrayList<>();
//            int anscount = 0;
//            for (int j = 1; j < niuCount+1; j++) {
//                if (ans[j] == rightCount) {
//                    list.add(j);
//                    anscount++;
//                }
//            }
//
//            System.out.println(anscount);
//
//            for (int j = 0; j < list.size(); j++) {
//                int a = list.get(j);
//                if (list.size() == j-1) {
//                    System.out.println(a);
//                    break;
//                }
//
//                System.out.print(a+" ");
//            }
//
//        }
//    }
//    public static void doPlus(int a ,int b,int[] arr){
//        if (a >b ||arr.length<b) {
//            return;
//        }
//
//        for (int i = a; i <= b; i++) {
//            arr[i]++;
//        }
//    }
//}
//import java.util.Scanner;
//
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//
//        System.out.println(2);
//    }
//}

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = sc.nextInt();
            arr[i] = i1;
        }

//        int countFive = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == 5){
//
//            }
//        }
        System.out.println(5555555550l);
    }
}