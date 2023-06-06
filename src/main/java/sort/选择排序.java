package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/5/22 01:22
 */
public class 选择排序 {

    public static void selectSort(int[] a){
        // 外层循环，n-1趟排序
        for(int i=0;i<a.length-1;i++){
            int min=i;//最小值的下标
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=a[i];
                a[i]=a[min];
                a[min]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,-1,9,7,10,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
