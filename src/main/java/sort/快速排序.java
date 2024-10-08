package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/5/24 00:34
 */
public class 快速排序 {
    public static void sort(int[] arr, int left, int right) {
        // 递归结束的条件
        if (left > right) {
            return;
        }
        // 因为left和right后面还需要用到这两个值，所以不应该用它们来遍历，而是用两个新的变量i，j
        int i = left;
        int j = right;
        // 将数组的第一个值当做基准值，用一个变量存起来
        int temp = arr[left];
        while (i != j) {
            // 从右往左走，找到第一个小于基准值的下标（必须加上i<j的限制，避免数组越界异常）
            while (arr[j] >= temp && i < j) {
                j--;
            }
            // 将找到的这个小于基准值的的数赋值给下标为i的位置，并且i++
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 从左往右走，找到第一个大于基准值的下标（必须加上i<j的限制，避免数组越界异常）
            while (arr[i] <= temp && i < j) {
                i++;
            }
            // 将找到的这个大于基准值的的数赋值给下标为j的位置，并且j--
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        // 一趟循环结束后，将保存起来的基准值temp赋给下标为i或者为j的位置
        arr[i] = temp;

        // 递归对基准值左右两边的数据进行快速排序
        sort(arr,left, i-1);
        sort(arr,i+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {3,-1,9,7,10,8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
