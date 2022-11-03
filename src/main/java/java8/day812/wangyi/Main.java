package java8.day812.wangyi;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        String[][] ints = new String[num][7];
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < 7; j++) {
//                String next = scanner.next();
//                ints[i][j] = next;
//            }
//        }
//
//
//        String[] ans = new String[num];
//
//        for (int i = 0; i < num; i++) {
//            Map<Integer, String> map = new HashMap<>();
//            Set<Integer> set = new HashSet<>();
//            for (int j = 0; j < 7; j++) {
//                char c = ints[i][j].charAt(0);
//                int now = c - '0';
//
//                set.add(now);
//
//                String s = map.get(now % 3);
//                if (s == null) {
//                    map.put(now%3, String.valueOf(ints[i][j].charAt(1)));
//                }else {
//                    boolean equals = s.equals(String.valueOf(ints[i][j].charAt(1)));
//                    if (equals == true) {
//                        continue;
//                    }else {
//                        ans[i] = "NO";
//                        break;
//                    }
//                }
//
//            }
//            if (set.size() == 7&&
//                    map.size()==3&&
//                    !map.get(0).equals(map.get(1))&&
//                    !map.get(1).equals(map.get(2))&&
//                    !map.get(0).equals(map.get(2))) {
//                ans[i] = "YES";
//            }else {
//                ans[i] = "NO";
//            }
//
//        }
//
//
//        for (int i = 0; i < num; i++) {
//            System.out.println(ans[i]);
//        }
//    }
//
//
//}

 //本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] ints = new int[num+1][num+1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                int next = scanner.nextInt();
                ints[i][j] = next;
            }
        }

        int[][] ans = new int[num][2];

        int[] hengxiang = new int[num + 1];
        int[] zhongxiang = new int[num + 1];
        int number = num;
        for (int i = 0; i < num; i++) {
            int[] max = max(hengxiang, zhongxiang,number);
            ans[i] = max;
            for (int j = max[0]; j <= number; j++) {
                hengxiang[j] = hengxiang[j++];
            }
            for (int k = max[1]; k <= number; k++) {
                zhongxiang[k] = zhongxiang[k++];
            }
            number--;
            ints = remove(max, ints);
        }

        for (int i = 1; i <= num; i++) {
            System.out.println(ans[0]+" "+ans[1]);
        }
    }

    public static int[] max(int[] hengxiang,int[] zhongxiang,int number) {
        int[] index = new int[2];
        int maxcout = -1;
        int maxcout2 = -1;
        for (int i = 1; i <= number; i++) {
            int i1 = hengxiang[i];
            if (i1 > maxcout) {
                maxcout = hengxiang[i];
                index[0] = i1;
            }
        }

        for (int i = 1; i <= number; i++) {
            int i1 = zhongxiang[i];
            if (i1 > maxcout2) {
                maxcout2 = zhongxiang[i];
                index[1] = i1;
            }
        }
        return index;
    }

    public static int[][] remove(int[] index,int[][] ints) {
        int[][] intsNew = new int[ints.length-1][ints.length-1];

        int x = 0;
        for (int i = 1; i <= ints.length; i++) {
            if (i == index[0]) {
                continue;
            }
            int y = 0;
            for (int j = 0; j < ints.length; j++) {
                if (j == index[1]) {
                    continue;
                }else {
                    intsNew[x][y] = ints[i][j];
                    y++;
                }
            }
            x++;
        }

        return intsNew;
    }
}


 //本题为考试单行多行输入输出规范示例，无需提交，不计分。
//import java.util.*;
//
//public class mydata.Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int[][] ints = new int[num+1][num+1];
////        next
//
//
//        System.out.println(0);
//    }
//
//    public static int max(int[] hengxiang,int[] zhongxiang) {
//        int index = 0;
//        int maxcout = -1;
//        for (int i = 1; i <= hengxiang.length; i++) {
//            int i1 = hengxiang[i] + zhongxiang[i];
//            if (i1 > maxcout) {
//                maxcout = hengxiang[i] + zhongxiang[i];
//                index = i;
//            }
//        }
//        return index;
//    }
//
//
//}