package stack;//package stack;// 本题为考试多行输入输出规范示例，无需提交，不计分。
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    static int[] arr = new int[1000];
//    static int start = 0;
//    static int end = 0;
//    static int size = 0;
//    public static void push(int a){
//        arr[end] = a;
//        end++;
//        size++;
//    }
//    public static void top(){
//        if (size == 0) {
//            System.out.println("-1");
//            return;
//        }
//        System.out.println(arr[start]);
//    }
//
//    public static void pop(){
//        if (size == 0) {
//            System.out.println("-1");
//            return;
//        }else {
//            start++;
//            size--;
//        }
//    }
//    public static void size(){
//        System.out.println(size);
//    }
//    public static void clear(){
//        arr = new int[1000];
//        start = 0;
//        end = 0;
//        size = 0;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<List<String>> strings = new ArrayList<>();
//        for(int i = 0; i < n; i++){
//            int times = sc.nextInt();
//            List<String> s1 = new ArrayList<>();
//            for(int j = 0; j < times; j++){
//                String next = sc.next();
//                if (next.equals("PUSH")) {
//                    String anInt = sc.next();
//                    s1.add("PUSH");
//                    s1.add(anInt);
//                }else {
//                    s1.add(next);
//                }
//            }
//            strings.add(s1);
//        }
//        for (List<String> s2:strings) {
//            for (int i = 0; i < s2.size(); i++) {
//                String next = s2.get(i);
//                if (next.equals("PUSH")) {
//                    i++;
//                    String s3 = s2.get(i);
//                    int anInt = Integer.parseInt(s3);
//                    push(anInt);
//                }else if (next.equals("POP")) {
//                    pop();
//                }else if (next.equals("TOP")) {
//                    top();
//                }else if (next.equals("SIZE")) {
//                    size();
//                }else if (next.equals("CLEAR")) {
//                    clear();
//                }
//            }
//            clear();
//        }
//    }
//}
//// 本题为考试多行输入输出规范示例，无需提交，不计分。
////import java.util.Scanner;
////
////public class Main {
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        for(int i = 0; i < n; i++){
////            int times = sc.nextInt();
////            List<String> s1 = new ArrayList<>();
////            for(int j = 0; j < times; j++){
////                String next = sc.next();
////                if (next.equals("PUSH")) {
////                    String anInt = sc.next();
////                    s1.add("PUSH");
////                    s1.add(anInt);
////                }else {
////                    s1.add(next);
////                }
////            }
////            strings.add(s1);
////        }
////}


//import java.util.ArrayList;
//        import java.util.LinkedList;
//        import java.util.List;
//        import java.util.Scanner;
//
//
//public class Main {
//
//    static  LinkedList s1;
//    static  LinkedList s2;
//
//    /**
//     * Initialize your data structure here.
//     */
//    static  {
//        s1 = new LinkedList();
//        s2 = new LinkedList();
//    }
//
//    private static void poll() {
//        if (s2.isEmpty()) {
//            while (!s1.isEmpty()){
//                int pop = (int)s1.pop();
//                s2.push(pop);
//            }
//        }
//        s2.pop();
//    }
//
//    private static void top() {
//        if (s2.isEmpty()) {
//            while (!s1.isEmpty()){
//                Integer pop = (int)s1.pop();
//                s2.push(pop);
//            }
//        }
//        System.out.println(s2.peek());
//    }
//
//    private static void add(int anInt) {
//        s1.push(anInt);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<String> strings = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if (next.equals("add")) {
//                String anInt = sc.next();
//                strings.add("add");
//                strings.add(anInt);
//            } else {
//                strings.add(next);
//            }
//        }
//        for (int i = 0; i < strings.size(); i++) {
//            String next = strings.get(i);
//            if (next.equals("add")) {
//                i++;
//                String s3 = strings.get(i);
//                int anInt = Integer.parseInt(s3);
//                add(anInt);
//            } else if (next.equals("poll")) {
//                poll();
//            } else if (next.equals("peek")) {
//                top();
//            }
//        }
//    }
//}
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //System.out.println(col(9));
        Scanner in = new Scanner(System.in);
        int anInt = in.nextInt();
        int[] ans = new int[anInt];
        for (int i = 0; i < anInt; i++) {
            int num = in.nextInt();
            int cen = in.nextInt();
            int change = num;
            if (col(change) <= cen) {
                ans[i] = -1;
                break;
            }
            while (!(col(change) == cen)){
                change = change/2;
            }
            ans[i] = change;
        }
        for (int i = 0; i < anInt; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int col(int change) {
        int x= change;
        int time = 0;
        while (!(x==0)){

            x = x/2;
            time++;
        }
        return time;
    }
}