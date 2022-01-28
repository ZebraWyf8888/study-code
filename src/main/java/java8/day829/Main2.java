package java8.day829;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: WYF
 * @Description: 构造小根堆（注意：小根堆就要先初始化大根堆，这样沉底出来才是小根堆）
 * @Create: 2020/4/2 21:02
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        String next = sc.next();
        String[] split = next.split(",");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        sort(ints,0,split.length-1);
        for (int i = 0; i < n-1; i++) {
            System.out.print(ints[i]+",");
        }
        System.out.println(ints[n-1]);
    }
    private static void sort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int temp;
        if (low > high) {
            return;
        }
        while (i < j) {
            while (arr[j] >= arr[low] && i < j) {
                j--;
            }
            while (arr[i] <= arr[low] && i < j) {
                i++;
            }

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        //System.out.println(Arrays.toString(arr));

        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }
}
