package macleetcode.code3.com.sort;

/**
 * @Author: WYF
 * @Description: 冒泡排序+优化
 * @Create: 2020/3/27 22:14
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {10, 8, 6, 2, 1, 3, 4, 5, 9, 0, 7};
        sort(a);
        System.out.println(a.length);
        for(int i :a){
            System.out.println(i + "--");
        }
    }

    private static void sort(int[] a) {
        /**
         * @Description:标志是否已经有序，若是，排序结束
        */
        boolean isSort = true;
        /**
         * @Description:记录最后一个改变的位置，该位置之后的数据没必要变化了 已经有序
        */
        int lastChange = 0;
        /**
         * @Description:lastchange是改变的，index是取最后的值，他们两个联合使用的
        */
        int index = a.length-1;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < index; j++) {
                if (a[j+1]>a[j]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    isSort = false;
                    lastChange = j;
                }
            }
            index = lastChange;
            if (isSort){
                break;
            }
        }
    }


}
