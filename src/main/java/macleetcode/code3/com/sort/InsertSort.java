package macleetcode.code3.com.sort;


/**
 * @Author: WYF
 * @Description: 插入排序
 * @Create: 2020/3/27 22:29
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = new int[]{12, 73, 45, 69, 35};
        sort2(a);
        System.out.println(a.length);
        for (int i : a) {
            System.out.println(i + "--");
        }
    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j= i-1; j >= 0 ; j--) {
                if (a[j] <= temp) {
                    break;
                }else {
                    a[j+1] = a[j];
                }
            }
            a[j+1] = temp;
        }
    }

    //https://www.cnblogs.com/chengxiao/p/6103002.html
    private static void sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j>0&&a[j-1]>a[j]){
                SelectSort.swap(a,j,j-1);
                j--;
            }
        }
    }




}
