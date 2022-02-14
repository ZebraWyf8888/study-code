package day20220214;

class Solution {
    /**
     * 找数组中只出现一次的元素，二分来找
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}
