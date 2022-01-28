package day906p2;


// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        HashSet<Integer> objects = new HashSet<>();
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < A; i++) {
            int i1 = in.nextInt();
            objects.add(i1);
        }
        int B = in.nextInt();
        for (int i = 0; i < B; i++) {
            int i1 = in.nextInt();
            if (objects.contains(i1)) {
                ans.add(i1);
            }
        }
        for (Integer a:
                ans) {
            System.out.print(a+" ");
        }
    }
}