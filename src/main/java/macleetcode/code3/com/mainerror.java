package macleetcode.code3.com;

import java.util.Scanner;

/**
 * @Description:快速排序
 * @Param:
 * @Return:
 * @Author: WYF
 * @Date: 2020/1/18 14:40
 */
public class mainerror {
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
        sort(a, 0, length-1);
        for (int i = 0; i < length; i++) {
            System.out.print(a[i]+" ");
        }

    }

    private static void sort(int[] a, int low, int high) {
        if (low>high) {
            return;
        }
        int temp = a[low];
        int i = low;
        int j = high;
        int t;
        while (i<j){
            while (a[i]<temp&&i<j){
                i++;
            }
            while (a[j]>temp&&i<j){
                j--;
            }
            if (i<j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        sort(a, low, i-1);
        sort(a, i+1, high);
    }
}

//这个没错啊啊啊，这个是另一种快速排序，5（第一个数字）一直参与着比较
//5 6 3 1 2
//

