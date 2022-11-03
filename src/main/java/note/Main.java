package note;////
//////机器人判分系统要求必须如下规则：
////// 1： 不能有package关键字
////// 2： 必须类名必须是Main
////
////import java.util.Scanner;
////public class mydata.Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int N = scanner.nextInt();
////        int count = 0;
////        int arr[] = new int[N];
////        for (int i = 0; i < N; i++) {
////            int a = scanner.nextInt();
////            arr[i] = a;
////        }
////
////        for (int i = 1; i < N-1; i++) {
////            if (small(arr, 0, i-1, arr[i])&&big(arr, i+1, N, arr[i])) {
////                count++;
////            }
////        }
////        System.out.println(count);
////
////    }
////
////    public static boolean big(int[] arr, int begin ,int end,int x){
////        for (int i = begin; i <= end; i++) {
////            if (arr[begin]>x){
////                return true;
////            }
////        }
////        return false;
////    }
////
////    public static boolean small(int[] arr, int begin ,int end,int x){
////        for (int i = begin; i <= end; i++) {
////            if (arr[begin]<x){
////                return true;
////            }
////        }
////        return false;
////    }
////}
//
//
////机器人判分系统要求必须如下规则：
//// 1： 不能有package关键字
//// 2： 必须类名必须是Main
//
////import java.util.Scanner;
////public class mydata.Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        int count = 0;
////        for (int i = 1; i <= n; i++) {
////            if (isAdd(i)) {
////                count++;
////            }
////        }
////        System.out.println(count);
////    }
////
////
////    public static boolean isAdd(int i){
////        int one = i%10;
////        int left = i/10;
////        int two = i/10%10;
////        if (two>one) {
////            return false;
////        }else {
////            if (left<10){
////                return true;
////            }
////            return isAdd(left);
////        }
////    }
////}
//
//
////机器人判分系统要求必须如下规则：
//// 1： 不能有package关键字
//// 2： 必须类名必须是Main
//
////import java.util.Scanner;
////public class mydata.Main {
////    public static void main(String[] args) {
////        //思路：找出元音+辅+元+辅的基本结构
////        //-》两个在中间的元音字母，且对于第二个元音，他左边和右边都有辅音字母
////        //且对于第1个元音，他到第二个原因间有辅的存在
////
////        //类似快速排序的思想
////        Scanner scanner = new Scanner(System.in);
////        String a = scanner.next();
////        int length = a.length();
////        char[] ch = a.toCharArray();
////        int i = 0;
////        int j = length-1;
////        while (i+1<j){
////            while (ch[i] != 'a'&&ch[i] != 'e'&&ch[i] != 'i'&&ch[i] != 'o'&&ch[i] != 'u'&&i+1<j){
////                i++;//相比快排。这里再第二次循环，值没有改变，不会进去
////            }
////            while (ch[j] != 'a'&&ch[j] != 'e'&&ch[j] != 'i'&&ch[j] != 'o'&&ch[j] != 'u'&&i+1<j){
////                j--;
////            }
////            if (i+1<j){
////                System.out.println("yes");
////                return;
////            }
////        }
////        System.out.println("no");
////    }
////}
//
//
//////机器人判分系统要求必须如下规则：
////// 1： 不能有package关键字
////// 2： 必须类名必须是Main
////
////import java.util.Scanner;
////
////public class mydata.Main {
////    public static void main(String[] args) {
////        //典型的图问题
////        //我想想，先输入，然后遍历把
////        //然后再说吧
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        int m = scanner.nextInt();
////        char[][] c = new char[n][m];
////        for (int i = 0; i < n; i++) {
////            String s = scanner.next();
////            char[] chars = s.toCharArray();
////            c[i] = chars;
////        }
////        int times = scanner.nextInt();
////        for (int i = 1; i <= times; i++) {
////            c = oneMonth(c);
////        }
//////        遍历
////        for (int i = 0; i < n; i++) {
////            for (char cc : c[i]) {
////                System.out.print(cc);
////            }
////            System.out.println();
////        }
////    }
////
////    public static char[][] oneMonth(char[][] c) {
////        char[][] chars = new char[][]{
////                {'.','.','.','.','.'},
////                {'.','.','.','.','.'},
////                {'.','.','.','.','.'},
////                {'.','.','.','.','.'},
////        };
////        for (int i = 0; i < c.length; i++) {
////            for (int j = 0; j < c[i].length; j++) {
////                if (c[i][j] == 'g') {
////                    chars[i][j] = 'g';
////                    if (i != 0) {
////                        chars[i - 1][j] = 'g';
////                    }
////                    if (j != 0) {
////                        chars[i][j - 1] = 'g';
////                    }
////                    if (i != 3) {
////                        chars[i + 1][j] = 'g';
////                    }
////                    if (j != 4) {
////                        chars[i][j + 1] = 'g';
////                    }
////                }
////            }
////        }
////        return chars;
////    }
////}
//
////机器人判分系统要求必须如下规则：
//// 1： 不能有package关键字
//// 2： 必须类名必须是Main
//
////import java.util.Scanner;
////
////public class mydata.Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        long l = scanner.nextLong();
////        long a = l;
////        long b = l - 1;
////        long gcd = gcd(a, b);
////        System.out.println(((a*b)-1)*gcd);
////    }
////
////    private static long gcd(long a, long b) {
////        while (true) {
////            if (a > b) {
////                a = a % b;
////                if (a == 0) {
////                    return b;
////                }
////            } else {
////                b = b % a;
////                if (b == 0) {
////                    return a;
////                }
////            }
////        }
////    }
////}
//
////有点像斐波那契数列
////正向递归
////优化的做法是从后往前想-->这个晚点在想
//
////import java.util.Scanner;
////public class mydata.Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        long[] a = new long[n];
////        for (int i = 0; i < a.length; i++) {
////            a[i] = scanner.nextLong();
////        }
////        int count = 0;
////        while (true){
////            int i = maxArr(a);
////            if (a[i]<n){
////                break;
////            }
////            a[i] = a[i] - n ;
////            for (int j = 0; j < a.length; j++) {
////                if (j == i) {
////                    continue;
////                }
////                a[j] = a[j]+1;
////            }
////            count++;
////        }
////        System.out.println(count);
////    }
////
////    private static int maxArr(long[] arr) {
////        long a = 0;
////        int index = 0;
////        for (int i = 0; i < arr.length; i++) {
////            if (arr[i] > a) {
////                a = arr[i];
////                index = i;
////            }
////        }
////        return index;
////    }
////}
//
//import java.util.Scanner;

//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] wight = new int[n];
//        for (int i = 0; i < wight.length; i++) {
//            wight[i] = scanner.nextInt();
//        }
//
//        int count = 0;
//        int[][] link = new int[n+1][n+1];
//        for (int i = 0; i < n-1; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            link[a][b] = 1;
//            link[b][a] = 1;
//        }
//
//
//        System.out.println(count);
//    }
//}

 //本题为考试多行输入输出规范示例，无需提交，不计分。
//import java.util.Scanner;
///**
//* @Author: WYF
//* @Description: 无向图判断是否连通，并查集
//* @Create: 2020/4/28 21:41
//* @Version: 1.0
//*/
//public class mydata.Main {
//    public static void main(String[] args) {
//
//    }
//}

// 本题为考试多行输入输出规范示例，无需提交，不计分。
//import java.util.Scanner;
//import java.util.Stack;
//
///**
//* @Author: WYF
//* @Description: 用栈实现消消乐
//* @Create: 2020/4/28 21:40
//* @Version: 1.0
//*/
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] s1 = new String[n];
//        for(int i = 0; i < n; i++){
//            s1[i] = sc.next();
//        }
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            char[] chars = s1[i].toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                if (stack.isEmpty()) {
//                    stack.push(chars[j]);
//                }else {
//                    if (stack.peek().equals(chars[j])) {
//                        stack.pop();
//                    }else {
//                        stack.push(chars[j]);
//                    }
//                }
//            }
//            if (stack.isEmpty()) {
//                s1[i] = "Yes";
//            }else {
//                s1[i] = "NO";
//            }
//            stack.clear();
//        }
//
//        for (String ss2:s1) {
//            System.out.println(ss2);
//        }
//    }
//}