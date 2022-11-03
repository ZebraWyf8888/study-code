package mydata;

public class Max {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param args
     */
    public static void main(String[] args) {
        int[] demo = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = max(demo);
        System.out.println(max);
    }

    public static int max(int[] nums){
        int ans = 0;
        int pre = nums[0];
        //pre[i] = num[i-1]+pre ,num[i];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
