package ahot;

import java.util.HashMap;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//你可以按任意顺序返回答案。
//
//示例 1：
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//示例 2：
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//示例 3：
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//提示：
//- 2 <= nums.length <= 10(4)
//- -10(9) <= nums[i] <= 10(9)
//- -10(9) <= target <= 10(9)
//- 只会存在一个有效答案
//    func twoSum(nums []int, target int) []int {
//
//    }
public class review {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int tar = 9;
        int[] ans = AddTwoSum(arr, tar);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    private static int[] AddTwoSum(int[] arr, int tar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            if (map.getOrDefault(tar - arr[i], -1) != -1) {
                return new int[]{map.get(tar - arr[i]), i};
            }
            map.put(arr[i], i);
        }

        return new int[]{0, 0};
    }
}
