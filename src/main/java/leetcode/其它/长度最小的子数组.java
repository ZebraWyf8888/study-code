package leetcode.其它;

/**
 * 滑动窗口（双指针法）
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/13 00:49
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; // 左指针
        int right = 0; // 右指针
        int len = 0; // 最小长度
        int sum = 0; // 窗口内的总和
        for (; right < nums.length; right++) {
            sum += nums[right];
            // 注意这里必须是while循环，因为有可能左指针移除掉一个元素后，还是符合条件，还得继续移除，直到不符合条件
            // 这里算法的复杂度并不是O(n^2)，因为不是每遍历一个for循环元素都会进入while循环
            while (sum >= target) {
                // 计算符合条件的窗口长度，并且和len值取最小值（注意初始化len为0的情况）
                len = len == 0 ? (right - left + 1) : Math.min(len, right - left + 1);
                sum -= nums[left];
                left ++;
            }
        }
        return len;
    }
}
