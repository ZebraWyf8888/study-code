package ahotreview;

public class 二分之旋转排序数组寻找两个有序数组的中位数 {
    /**
     *搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // <=
        while (low < high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }else if (nums[mid] >= nums[high]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


}
