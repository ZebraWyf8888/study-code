package macleetcode.code3.com.sort;

import java.util.Scanner;

/**
 * @Author: WYF
 * @Description: 快速排序
 * @Create: 2020/2/7 0:12
 * @Version: 1.0
 */
public class QuickSort {
    /**
     * public static只能修饰成员变量或者成员方法
     * 原因：局部变量是随着方法调用而在内存开辟空间，方法结束而释放
     * 而static，public是用来声明全局变量或是被其他对象引用的变量
     */
    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[MAX];
        int length;
        for (length = 0; length < MAX; length++) {
            int a = scanner.nextInt();
            if (a == 0) {
                break;
            }
            arr[length] = a;
        }
        sort(arr, 0, length - 1);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
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
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }
    private static void  sort2(int[] arr ,int low,int high){
        int i = low;
        int j = high;
        int temp ;
        while (i<j){
            while (arr[low] >arr[j] && i<j){
                j--;
            }
            while (arr[low] >arr[i] && i<j){
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
    private static void sort3(int arr[],int start,int end){
        int i = start;
        int j = end;
        int temp = 0;
        while (i<j){
            while (arr[j]>arr[start]&&i<j){
                j--;
            }
        }
    }
}
