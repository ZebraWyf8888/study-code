package java8.com.sort;

public class SheelSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 73, 45, 69, 352};
        sort1(a);
        System.out.println(a.length);
        for (int i : a) {
            System.out.println(i + "--");
        }
    }

    /**
     * @Description: https://www.cnblogs.com/chengxiao/p/6104371.html
     * @Param: [a]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/29 13:14
     */
    private static void sort1(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                /**
                 * 这的插入排序，是多个数组同时进行的
                 * 从每个数组的第i+1位置开始
                 */
                int j = i;
                while (j - gap >= 0 && a[j] < a[j - gap]) {
                    swap(a, j, j - gap);
                    j = j - gap;
                }
            }
        }
    }

    /**
     * @Description: 不适合两个值相等的情况
     * @Param: [arr, a, b]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/3 0:48
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
