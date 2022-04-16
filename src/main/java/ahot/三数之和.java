package ahot;

import java.util.ArrayList;
import java.util.List;

public class 三数之和 {
    /**
     * 三数之和，难度在去重
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {

            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int tar =  - nums[i];

            for (int second = i + 1; second < nums.length; second++) {
                if (second > i+1 && nums[second] == nums[second-1]) {
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > tar) {
                    --third;
                }
                
                if (second == third){
                    break;
                }

                if (nums[second] + nums[third] == tar) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(ints);


    }
    public static void quickSort(int[] num,int low,int high){
        int i = low;
        int j = high;
        int temp;

        if (i > j) {
            return;
        }
        int k = num[low];

        while (i < j){
            while (num[j] >= k && i < j) {
                j--;
            }

            while (num[i] <= k && i < j) {
                i++;
            }

            if (i < j) {
                temp = num[j];
                num[j] = num[i];
                num[i] = temp;
            }
        }

        temp = num[low];
        num[low] = num[i];
        num[i] = temp;


        quickSort(num,low,i-1);
        quickSort(num,i+1,high);


    }
}
