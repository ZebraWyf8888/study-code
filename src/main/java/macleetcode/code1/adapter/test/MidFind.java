package macleetcode.code1.adapter.test;

/**
* @Author: WYF
* @Description: 二分查找
* @Create: 2020/3/27 17:49
* @Version: 1.0
*/
public class MidFind {
    public int search(int[] num,int low,int high,int targer){
        if (low>high ||
               num.length == 0 || targer > num[high]|| targer < num[low]) {
            return -1;
        }
        /**
         * 两个优化：1.从 （high + low）/2改为low + （high-low）/2
         * 2.改为 low+（high-low）*（index - arr[low]）/（arr[high]-arr[low]）
        */
        int mid = low+(high-low)*(targer - num[low])/(num[high]-num[low]);
        if (num[mid] > targer){
            return search(num, low, mid-1, targer);
        }else if (num[mid] < targer){
            return search(num, mid+1, high, targer);
        }else {
            return mid;
        }

    }
}
