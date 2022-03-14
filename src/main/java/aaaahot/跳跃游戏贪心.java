package aaaahot;

public class 跳跃游戏贪心 {
    /**
     * 跳跃游戏1，判断能不能到最后一个格子，维护jumpMax，
     *  jumpMax不能到i（递增的点），就返回false，到底了，更新不上去；
     *          能到，就更新jump，如果jumpMax >= n-1，说明到达最后一个了 返回true
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int jumpMax = 0;
        for(int i = 0;i<nums.length;i++){
            if(i<=jumpMax){
                if(jumpMax >= n-1){
                    return true;
                }
                jumpMax = Math.max(jumpMax,i+nums[i]);
            }else {
                return false;
            }
        }
        return false;
    }

    /**
     *
     *  思想就一句话：每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
     *  每次都是从1开始，假设index【0】为4，就找index【0-4】内一个能跳的最远的，到了四，就要产生跳跃
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int ansStep = 0; // 跳跃次数 ans
        int end = 0;//上次产生跳跃后，可达范围右边界（也是下次的最右起跳点）
        int maxRight = 0;// 目前能跳到的最远位置
        for(int i = 0;i < nums.length -1 ;i++){
            maxRight = Math.max(maxRight,nums[i] + i);
            // 到达上次跳跃能到达的右边界了，要产生跳跃
            if(i == end){
                ansStep++;
                end = maxRight;
            }
        }
        return ansStep;
    }

}
