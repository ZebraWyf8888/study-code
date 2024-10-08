package ahot;

/**
 *
 * 连续子数组的最大和
 * 最大连续和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class 连续子数组的最大和 {
    public int findLengthOfLCIS(int[] nums) {
        int length = 1;
        int lengthans = 0;
        int lastIndex = 0;
        int ans = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i]+max) {
                max = nums[i];
                length = 1;
            }else {
                max = nums[i]+max;
                length ++;
            }
            if (ans < max) {
                ans = max;
                lengthans = length;
                lastIndex = i;
            }
        }
        System.out.println("lengthans"+lengthans);
        System.out.println("lastIndex"+lastIndex);
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
//        数组去重
//                正确的括号算法
        连续子数组的最大和 solution = new 连续子数组的最大和();
        int[] ans = new int[]{5,4,-1,7,8};
        int lengthOfLCIS = solution.findLengthOfLCIS(ans);

        System.out.println("lengthOfLCIS:"+lengthOfLCIS);


    }
}