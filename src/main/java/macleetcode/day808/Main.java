package macleetcode.day808;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Long ans = in.nextLong();
        Long length = in.nextLong();
        Long[] Longs = new Long[length.intValue()];

        for (int i = 0; i < length; i++) {
            Longs[i] = in.nextLong();
        }

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i < ans+1; i++) {
            boolean xx = false;
            for (int j = 0; j < length; j++) {
                if (Longs[j].intValue()==i) {
                    xx = true;
                    break;
                }
            }
            if (xx == false) {
                integers.add(i);
            }
        }

        Long[] Longs2 = new Long[ans.intValue()];
        int arr = 0;
        int list = 0 ;
        for (int i = 0; i < ans.intValue(); i++) {
            if (list>=integers.size()) {
                Longs2[i] = Longs[arr++];
            }

            if (arr>=Longs.length) {
                Longs2[i] = Longs[list++];
            }
            if (integers.get(list)< Longs[arr]) {
                Integer integer = integers.get(list);
                Longs2[i] =integer.longValue();
                list ++;
            }else {
                Longs2[i] = Longs[arr];
                arr++;
            }
        }


        //System.out.println(count);
        for (int i = 0; i < ans.intValue(); i++) {
            if (i == length - 1) {
                System.out.print(Longs2[i]);
            } else {
                System.out.print(Longs2[i] + " ");
            }
        }
    }
}