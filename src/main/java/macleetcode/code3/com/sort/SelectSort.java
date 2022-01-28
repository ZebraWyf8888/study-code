package macleetcode.code3.com.sort;

import java.util.Arrays;

/**
* @Author: WYF
* @Description: 简单选择排序
* @Create: 2020/4/3 0:07
* @Version: 1.0
*/
public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[]{12, 73, 45, 69, 35};
        selectSort(a);
        System.out.println(a.length);
        for (int i : a) {
            System.out.println(i + "--");
        }
    }

    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int index = i;
            int temp = a[i];
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    index = j;
                }
            }
            swap(a, i, index);
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * @Description: https://www.cnblogs.com/10158wsj/p/6782124.html
     * @Param: [a]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/29 13:14
    */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
