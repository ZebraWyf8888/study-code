package macleetcode.code3.com;

/**
* @Author: WYF
* @Description: 二分查找
* @Create: 2020/3/27 17:49
* @Version: 1.0
*/
public class MidFind {
    public static void main(String[] args) {
        int[] nums={-5,0,1,2,3,5,7,9,10,15,20,28,50,56};
        System.out.println(searchInsert(nums,0,13,9));
    }
    public static int searchInsert(int[] num,int low,int high,int targe){
        if (low>high ||
               num.length == 0 || targe > num[high]|| targe < num[low]) {
            return -1;
        }
        /**
         * 两个优化：1.从 （high + low）/2改为low + （high-low）/2
         * 2.改为 low+（high-low）*（index - arr[low]）/（arr[high]-arr[low]）
        */
        int mid = low+(high-low)*(targe - num[low])/(num[high]-num[low]);
        if (num[mid] > targe){
            return searchInsert(num, low, mid-1, targe);
        }else if (num[mid] < targe){
            return searchInsert(num, mid+1, high, targe);
        }else {
            return mid;
        }
    }
}
