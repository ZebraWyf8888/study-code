package recall;


import java.util.Arrays;

/**
* @Author: WYF
* @Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。
* @Create: 2020/5/3 16:05
* @Version: 1.0
*/
public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] a= {2,3,1,1,4};
        int[] b= {3,2,1,0,4};
        boolean b1 = canJump.canJump(a);
        boolean b2 = canJump.canJump(b);
        System.out.println(b1);
        System.out.println("-------");
        System.out.println(b2);
    }

    private boolean canJump(int[] nums) {
        //int length = nums.length;
        //int rightmost = 0;
//        for (int i = 0; i < length; i++) {
//            //i->当前位置
//            //rightmost 可达最远位置
//            //if (i <= rightmost) 判断该位置是不是可达
//            if (i <= rightmost) {
//                rightmost = Math.max(rightmost, i+nums[i]);
//                if (rightmost >= length-1) {
//                    return true;
//                }
//            }
//        }
//        return false;
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    /** 递归回溯解决，超时了
     Boolean[] a;
    public boolean canJump(int[] nums) {
        a = new Boolean[nums.length];
        Arrays.fill(a, false);
        a[0] = true;
        canJump(nums, 0);
        return a[nums.length-1];
    }

    public void canJump(int[] nums,int index) {
        if (a[nums.length-1]) {
            return;
        }
        for (int i = 1; i <= nums[index]&&(i+index)<nums.length; i++) {
            a[index+i] = true;
            canJump(nums, i + index);
            if (i+index == nums.length-1&&a[index+i] == true) {
                return;
            }
            a[index+i] = false;
        }
    }*/


}
