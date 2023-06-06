package hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 直接两层for循环，时间复杂度O(n^2)
 * 为了降低时间复杂度到O(n),引进HashMap
 * 这里不能使用双指针的原因是，题目是要返回符合条件的下标，而不是具体的值，如果使用双指针就必须进行排序，会导致下标混乱
 *
 * 题目中提及每种输入只会对应一个答案，也就是数组不存在重复元素
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 23:08
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // key为数组的值，value为下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 题目中提到数组中同一个元素在答案里不能重复出现。因此需要排除调自己和自己相加等于target的情况
            if (map.containsKey(temp) && map.get(temp) != i) {
                res[0] = i;
                res[1] = map.get(temp);
            }
        }
        return res;
    }
}
