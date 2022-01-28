package macleetcode.day1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Solution {
    /**
     *两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (integerIntegerHashMap.containsKey(target - now)) {
                return new int[]{integerIntegerHashMap.get(target-now),i};
            }
            integerIntegerHashMap.put(nums[i],i);
        }
        return new int[0];
    }

    /**
     * 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i>0 && (nums[i] == nums[i-1])) {
                continue;
            }

            int L = i + 1;
            int R = len -1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (nums[L] == nums [L-1]) L++;//去重
                    while (nums[R] == nums [R-1]) R--;//去重
                    L++;
                    R--;
                }else if (sum < 0) {
                    L++;
                }else if (sum > 0) {
                    R--;
                }
            }
         }
        return ans;
    }
}
