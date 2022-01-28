package macleetcode.code3;

import java.util.Scanner;

/**
 * 快速排序
 *
 * @author WYF
 * @date 2020/02/06
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[100];
        int length = 0;
        while (length < 100) {
            int temp = scanner.nextInt();
            if (temp == 0) {
                break;
            }
            a[length] = temp;
            length++;
        }
        sort(a, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    private static void sort(int[] a, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        temp = a[low];
        i = low;
        j = high;
        while (i < j) {
            while (a[j] >= temp && i < j) {
                //先比较后移动
                j--;
            }
            while (a[i] <= temp && i < j) {
                //这里好像多了一步和自己比较，但是没关系，反正也是i++ 会通过的
                i++;
            }
            if (i < j) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        //核心1：上面这两个循环， 不是找一次就OK，一直找一直交换，找到i<j为止
        //核心2：循环结束了，到了考虑临界的情况，上面的i<j挺精髓的，每一步都设置了i不能大于j
        //那么 一种只有一种情况就是i==j
        if (i == j) {
            t = a[low];
            a[low] = a[i];
            a[i] = t;
        }
        //核心3 递归嘛 我干一点然后交给别人去干就行了
        sort(a, low, i - 1);
        sort(a, j + 1, high);
    }
}

//注意：
// 1.
// <=、>=和<、>的区别，可以说整个是整个算法的灵魂，如果换成<和 >
// 就是另一种快速排序了，一直拿第一个数字比较的那种，不去掉就是浪费时间效率
//2.
// int temp1 = a[low];
//        a[low] = a[j];
//        a[j] = temp1;
//是a[low] 与a[j]交换不是a[j]与temp交换
//3.
//右边的兵必须先移动，才能保证左边的是小的
