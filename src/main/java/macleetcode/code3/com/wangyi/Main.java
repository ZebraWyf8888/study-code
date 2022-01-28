package macleetcode.code3.com.wangyi;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static int y = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        y = sc.nextInt();
        int[] a1 = new int[x];
        int[] a2 = new int[x];
        for (int i = 0; i < x; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < x; i++) {
            a2[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; ; i++) {
            find(x, a1, a2);

            count = count + a1[i];

        }



    }

    private static void find(int x, int[] a1, int[] a2) {
        for (int i = 0; i < x; i++) {
            if (y > a1[i]) {
                y++;
                a2[i] = 0;
            }
        }
    }

    private static void sort(int[] a, int[] b) {
        boolean isSort = true;
        int lastChange = 0;
        int index = a.length - 1;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < index; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    int temp2 = b[j + 1];
                    b[j + 1] = b[j];
                    b[j] = temp2;
                    isSort = false;
                    lastChange = j;
                }
            }
            index = lastChange;
            if (isSort) {
                break;
            }
        }
    }
}
