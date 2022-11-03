package mydata;//import java.util.Scanner;
//
////import java.util.Scanner;
////
//public class mydata.Main {
//    static int[] a;
//    static int[] ans;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        a = new int[n];
//        ans = new int[n];
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            a[i] = x;
//        }
//        for (int i = 0; i < n; i++) {
//            if (a[i]==0) {
//                ans[i] = ans[i]+1;
//            }else {
//                findZero(i);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(ans[i]);
//        }
//
//    }
//
//    private static void findZero(int i) {
//        if (i > a.length-1 && i < 0) {
//            return;
//        }
//        if (a[i] > i+1) {
//            return;
//        }
//        ans[i]++;
//        if (a[a[i]-1] == 0) {
//            ans[a[i]-1]++;
//            return;
//        }else {
//            findZero(a[i]-1);
//        }
//    }
//}

// 本题为考试多行输入输出规范示例，无需提交，不计分。

//import java.util.Scanner;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int x = sc.nextInt();
//        int[][] ans = new int[n][n];
//        for (int i = 0; i < m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            a--;
//            b--;
//            ans[a][b] = sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(ans[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(ans);
//    }
//}



//public class mydata.Main {
//
//
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        int anInt = in.nextInt();
//
//        boolean res[] = new boolean[anInt];
//        int[][] a = new int[anInt][12];
//        for (int i = 0; i < anInt; i++) {
//            for (int j = 0; j < 12; j++) {
//                 a[i][j] = in.nextInt();
//            }
//        }
//
//        for (int i = 0; i < anInt; i++) {
//            sort(a[i], 0, 11);
//        }
//        for (int i = 0; i < anInt; i++) {
//            res[i] = true;
//            for (int j = 0; j < 12; j=j+4) {
//                if (a[i][j] != a[i][j+1] || a[i][j+2] != a[i][j+3] || a[i][j+1] != a[i][j+2]) {
//                    res[i] = false;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < anInt; i++) {
//            for (int j = 0; j < 12; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < anInt; i++) {
//            if (res[i] == true) {
//                System.out.println("POSSIBLE");
//            }else {
//                System.out.println("IMPOSSIBLE");
//            }
//        }
//    }
//
//    private static void sort(int[] arr, int low, int high) {
//        int i = low;
//        int j = high;
//        int temp ;
//        if (low > high) {
//            return;
//        }
//        while (i < j) {
//            while (arr[j]>=arr[low]&&i<j){
//                j--;
//            }
//            while (arr[i]<=arr[low]&&i<j){
//                i++;
//            }
//
//            temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//
//        }
//        temp = arr[low];
//        arr[low] = arr[j];
//        arr[j] = temp;
//        sort(arr, 0, j-1);
//        sort(arr,j+1 ,high);
//    }
//}
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int anInt = in.nextInt();
//        int[][] a = new int[anInt][2];
//        for (int i = 0; i < anInt; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            a[i][0] = x;
//            a[i][1] = y;
//        }
//        System.out.println(anInt);
//    }
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int i = lengthOfLongestSubstring2(next);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (j < n && i < n) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j++), j);
                count = Math.max(j-i, count);
            }else {
                i = Math.max(i, map.get(s.charAt(j)));
                map.put(s.charAt(j++), j);
                count = Math.max(j-i, count);
            }
        }
        return count;
    }
}
//import java.util.Scanner;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] ch =new int[m+2][n+2];
//        for (int i =1 ; i <= n ;i++){
//            ch[1][i]=n-i+1;
//        }
//        for(int i=2;i<=m;i++){
//            if((i&1)==1){
//                for(int j=n;j>=1;j--) {
//                    ch[i][j] = (ch[i - 1][j - 1] + ch[i][j + 1]) % 1000;
//                }
//            }else{
//                for(int j=1;j<=n;j++) {
//                    ch[i][j] = (ch[i - 1][j + 1] + ch[i][j - 1]) % 1000;
//                }
//            }
//        }
//
//        for (int i = 0; i < m+2; i++) {
//            for (int j = 0; j < n+2; j++) {
//                System.out.print(ch[i][j]+" ");
//            }
//            System.out.println();
//        }
//        int result= (m&1)==1? ch[m][1]:ch[m][n];
//        System.out.println(result);
//    }
//}
//https://www.cnblogs.com/Flyfishy/p/12724949.html


//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int anInt = in.nextInt();
//        HashSet<Star> stars = new HashSet<>();
//        List<Star> liststars = new ArrayList<>();
//        //插入所有星
//        for (int i = 0; i < anInt; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            Star star = new Star(x, y);
//            liststars.add(star);
//            stars.add(star);
//        }
//        int num = 0;
//        //遍历星
//        for (int i = 0; i < anInt; i++) {
//            Star star = liststars.get(i);
//            int x = star.getX();
//            int y = star.getY();
////            for (int j = 0; j < anInt; j++) {
////                if (stars.contains(new Star(x,y-j))){
////                    for (int j2 = 0; j < anInt; j2++) {
////                        if (stars.contains(new Star(x,y+j2))){
////                            for (int j3 = 0; j < anInt; j3++) {
////                                if (stars.contains(new Star(x+j3,y))){
////                                    for (int j4 = 0; j < anInt; j4++) {
////                                        if (stars.contains(new Star(x-j4,y))){
////                                            num++;
////                                        }
////                                        break;
////                                    }
////                                    break;
////                                }
////                            }
////                            break;
////                        }
////                    }
////                    break;
////                }
////            }
//            if (
//                    stars.contains(new Star(x,y-1))&&
//                    stars.contains(new Star(x,y+1))&&
//                    stars.contains(new Star(x-1,y))&&
//                    stars.contains(new Star(x+1,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-2))&&
//                    stars.contains(new Star(x,y+2))&&
//                    stars.contains(new Star(x-2,y))&&
//                    stars.contains(new Star(x+2,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-3))&&
//                            stars.contains(new Star(x,y+3))&&
//                            stars.contains(new Star(x-3,y))&&
//                            stars.contains(new Star(x+3,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-3))&&
//                            stars.contains(new Star(x,y+2))&&
//                            stars.contains(new Star(x-2,y))&&
//                            stars.contains(new Star(x+2,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-1))&&
//                            stars.contains(new Star(x,y+2))&&
//                            stars.contains(new Star(x-3,y))&&
//                            stars.contains(new Star(x+4,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-1))&&
//                            stars.contains(new Star(x,y+2))&&
//                            stars.contains(new Star(x-2,y))&&
//                            stars.contains(new Star(x+4,y))
//                    ){
//                num++;
//            }else if (
//                    stars.contains(new Star(x,y-1))&&
//                            stars.contains(new Star(x,y+4))&&
//                            stars.contains(new Star(x-2,y))&&
//                            stars.contains(new Star(x+3,y))
//                    ){
//                num++;
//            }
//        }
//
//        System.out.println(num);
//    }
//
//}
//class Star{
//    int x;
//    int y;
//
//    public Star(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public Star() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {return true;}
//        if (o == null || getClass() != o.getClass()) {return false;}
//        Star star = (Star) o;
//        return x == star.x &&
//                y == star.y;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    @Override
//    public String toString() {
//        return "Star{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(x, y);
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//}

//import java.io.*;
//import java.util.*;
//public class mydata.Main
//{
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        //ArrayList<String> arr = new ArrayList<>();
//        int num= cin.nextInt();
//        int person = cin.nextInt();
//        int[] u = new int[num];
//        int[] v = new int[num];
//        for (int i = 0; i < num; i++) {
//            u[i] = cin.nextInt();
//            v[i] = cin.nextInt();
//        }
//        int[][] dp = new int[num][person];
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < person; j++) {
//                if (j == null) {
//
//                }
//            }
//        }
//        System.out.println();
//    }
//}