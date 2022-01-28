package macleetcode.code1.adapter.test;

import java.util.Scanner;

/**
* @Author: WYF
* @Description: 被适配的快速排序方法
*/
public class QuickSort {
    public void sort(int[] arr, int low, int high) {
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
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }
}
