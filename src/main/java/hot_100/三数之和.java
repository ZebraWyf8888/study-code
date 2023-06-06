package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * 使用双指针法，需要提前对数组进行排序，难点在于去重
 *
 * 1. 先对数组进行排序
 * 2. 遍历一遍数组，初始时：左指针left指向当前遍历到的元素的下一位，右指针right指向数组的最后一位，三数之和即为nums[i]+nums[left]+nums[right]
 * 3. 如果当前遍历到的元素值大于0，直接结束循环
 * 4. 第一次去重，如果当前循环遍历到的值等于上一个遍历的值，直接跳过这次循环
 * 5. 如果nums[i] + nums[left] + nums[right] < 0，左指针收缩，让整体值变大；
 *    如果nums[i] + nums[left] + nums[right] > 0，右指针收缩，让整体值变小；
 *    如果nums[i] + nums[left] + nums[right] = 0，符合条件，将三元组加入结果值里面，同时左右指针一起收缩
 *    并且还需要做第二次去重，如果left指向的值等于上一次left指向的值，left++；如果right指向的值等于上一次right指向的值，right--
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 22:43
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历一遍数组，初始时：左指针left指向当前遍历到的元素的下一位，右指针right指向数组的最后一位，三数之和即为nums[i]+nums[left]+nums[right]
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前遍历到的元素值大于0，直接结束循环
            if (nums[i] > 0) {
                return res;
            }
            // 第一次去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    // 左指针收缩，让整体值变大
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    // 右指针收缩，让整体值变小
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 左右指针同时收缩
                    left++;
                    right--;
                    // 第二次去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
