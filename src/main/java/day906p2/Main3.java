package day906p2;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i3 = in.nextInt();
        int A = in.nextInt();
        List<HashSet<Integer>> all = new ArrayList<>(A);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < A; i++) {
            int i1 = in.nextInt();
            HashSet<Integer> objects1 = new HashSet<>(i1);
            for (int j = 0; j < i1; j++) {
                int i2 = in.nextInt();
                objects1.add(i2);
            }
           all.add(objects1);
        }
        int sizeof = 0;
        while (true){
            boolean flag  = true;
            for (int i = 0; i < all.size(); i++) {
                HashSet<Integer> set1 = all.get(i);
                List<Integer> integers1 = new ArrayList<>(set);
                for (int j = 0; j < integers1.size(); j++) {
                    if (set1.contains(integers1.get(j))) {
                        set.addAll(set1);
                        flag = false;
                    }
                }
            }
            if (sizeof == set.size()) {
                break;
            }else {
                sizeof = set.size();
            }
            if (flag) {
                break;
            }
        }
        System.out.println(set.size());
    }
}