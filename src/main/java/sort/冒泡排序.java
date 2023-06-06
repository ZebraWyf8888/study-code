package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/5/22 00:58
 */
public class 冒泡排序 {

    public static void bubbleSort(int[] a){
        //外层循环：需要n-1趟排序
        for(int i=0;i<a.length-1;i++){
            /**
             *对冒泡排序的优化：设置一个标志，如果在某趟排序中并没有交换数据
             *则表示已经是有序的了，不需要进行排序，可以直接退出循环*/

            boolean flag=false;//需要注意该标志位应该放置在第一层循环内

            //内层循环：每趟排序需要比较的次数
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=true;
                }
            }

            if(!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,-1,9,7,10,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
