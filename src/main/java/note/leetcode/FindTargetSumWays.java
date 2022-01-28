package note.leetcode;

public class FindTargetSumWays {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums,S,0,0);
        return count;
    }

    private void calculate(int[] nums, int target, int i, int now) {
        if (i == nums.length) {
            if (target == now) {
                count++;
            }
        }else {
            calculate(nums, target, i-1, now-nums[i]);
            calculate(nums, target, i+1, now+nums[i]);
        }
    }
}
