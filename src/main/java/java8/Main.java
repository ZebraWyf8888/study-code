package java8;////import java.util.Scanner;
////
////public class mydata.Main {
////    /**
////     * @Description:
////     * @Param: [args]
////     * @Return: void
////     * @Author: WYF
////     * @Date: 2020/3/14 21:26
////    */
//////    public static void main(String[] args) {
//////        Scanner sc = new Scanner(System.in);
//////        String a = sc.next();
//////        for (int i = 0; i < a.length(); i++) {
//////            if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
//////                System.out.print(Character.toLowerCase(a.charAt(i)));
//////            } else {
//////                System.out.print(Character.toUpperCase(a.charAt(i)));
//////            }
//////        }
//////    }
////    public static void main(String[] args) {
////        Scanner get = new Scanner(System.in);
////        String str = get.next();
////        char[] ch = str.toCharArray();
////        for (int i = 0; i < ch.length; i++) {
////            if (ch[i] > 'Z') {
////                ch[i]-=('a'-'A');
////            }else if (ch[i] <= 'Z') {
////                ch[i]+=('a'-'A');
////            }
////        }
////
////        for (char c:ch) {
////            System.out.print(c);
////        }
////        get.close();
////    }
////}
//
//// 本题为考试多行输入输出规范示例，无需提交，不计分。
//
//import com.sun.jmx.remote.internal.ArrayQueue;
//
//import java.util.Scanner;
//
//public class mydata.Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String trim = sc.nextLine().trim();
//        String[] split = trim.split(",");
//        int all[] = new int[3];
//        for (int i = 0, j = 0; i < 7; i += 3, j++) {
//            all[j] = Integer.parseInt(split[i + 0]) +
//                    Integer.parseInt(split[i + 1]) +
//                    Integer.parseInt(split[i + 2]) +
//                    Integer.parseInt(split[(i + 3)%9]);
//        }
//        System.out.println(all[0]+"");
//        System.out.println(all[2]+"");
//        System.out.println(all[1]+"");
//        if (all[0] == all[1] && all[1] == all[2]) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//    }
//
//}

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int a = 0;
//        int b = 0;
//        int c = 0;
//
//        for(int i = 0; i < s.length(); i++){
//            if (s.charAt(i) == '(') {
//                a++;
//            }else if (s.charAt(i) == ')') {
//                if (a>0) {
//                    a--;
//                    c++;
//                }else {
//                    b++;
//                }
//            }
//        }
//        System.out.println(c+" "+a+" "+b);
        Map<String, String> objectObjectHashMap = new HashMap<>();
//        Set<Object> objects = objectObjectHashMap.keySet();

        Set<Map.Entry<String, String>> entries = objectObjectHashMap.entrySet();

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        objectObjectHashMap.put("A", "A");
        while(iterator.hasNext()) {
            Map.Entry map1=iterator.next();
            System.out.println(map1);
        }
//        Iterator<Map.Entry<String, String>> iterator2 = entries.iterator();
//        //objectObjectHashMap.put("B", "B");
//        while(iterator2.hasNext()) {
//            Map.Entry map1=iterator.next();
//            System.out.println(map1);
//        }
    }
}