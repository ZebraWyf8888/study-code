package note.leetcode;

public class Find {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        Find find = new Find();
        int[] ints = find.searchRange(nums, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int mid = findMid(nums, target, 0, nums.length - 1);
        int[] arr = new int[]{mid,mid};
        if (mid != -1) {
            for (int i = mid+1;i>=0&&i<=nums.length-1&&nums[i]==nums[mid] ; i++) {
                arr[1] = i;
            }
            for (int i = mid-1;i>=0&&i<nums.length-1&&nums[i]==nums[mid]; i--) {
                arr[0] = i;
            }
        }

        return arr;
    }

    private int findMid(int[] nums,int target,int start,int end) {
        if (start > end || nums.length == 0) {
            return -1;
        }
        int mid = (end-start)/2+start;
        if (nums[mid]>target){
            return findMid(nums, target, start, mid-1);
        }else if (nums[mid]<target){
            return findMid(nums, target, mid+1, end);
        }else {
            return mid;
        }
    }

}
