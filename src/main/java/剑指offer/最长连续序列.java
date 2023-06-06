package 剑指offer;

import java.util.HashSet;

/**
 * 最长连续序列
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/4 01:53
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        // 由于时间复杂度要求O(n)，采用空间换时间的方式，引进set，空间复杂度O(n)
        // 引进set的好处是set查找一个数的时间复杂度是O(1)，同时还能去除重复的数字
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (Integer num : nums) {
            hashSet.add(num);
        }
        int ans = 0;
        // 时间复杂度是O(n)，虽然存在内层while循环，但是不是所有数都会进入内层while循环，只有一个数不存在前驱数的情况下
        // 才会进入while循环，例如遍历到的数是3，如果set存在2，那么跳过3不处理，因为3会在2的处理中被处理
        for (int num : hashSet) {
            if (!hashSet.contains(num - 1)) {
                int currNum = num;
                int currCount = 1;
                while (hashSet.contains(currNum + 1)) {
                    currCount++;
                    currNum++;
                }
                ans = Math.max(ans, currCount);
            }
        }
        return ans;
    }
}
