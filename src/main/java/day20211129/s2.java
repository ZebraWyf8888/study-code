package day20211129;

import dfsandbfs.Soultion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class s2{
    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            //升序排序，后面的数字比前面都大，再选出来的数字只会大于0
            if(nums[k] > 0) {
                break;
            }
            //与前一个数字相同，去重
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            //双指针
            int start = k + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[k] + nums[start] + nums[end];
                if(sum < 0){
                    while(start < end && nums[start] == nums[++start]);//四个while都是为了去重，麻烦
                } else if (sum > 0) {
                    while(start < end && nums[end] == nums[--end]);
                } else {
                    List<Integer> integers = new ArrayList<Integer>();
                    integers.add(nums[k]);
                    integers.add(nums[start]);
                    integers.add(nums[end]);
                    res.add(integers);
                    while(start < end && nums[start] == nums[++start]);
                    while(start < end && nums[end] == nums[--end]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        s2 s2 = new s2();
        int[] a= new int[]{1,2,3,-1,-2,-3};
        s2.threeSum(a);
    }

    /**
     * 快速排序方法
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high) {
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
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
