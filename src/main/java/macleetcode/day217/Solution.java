package macleetcode.day217;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int high = arr.length-1;
        int low = 0;
        int mid = -1;
       while (low<high){
             mid = low+(high-low)/2;
            if (arr[mid] > arr[mid+1]&&arr[mid] > arr[mid-1]) {
                return mid;
            }else if (arr[mid] > arr[mid-1]&&arr[mid] < arr[mid+1]){
                low = mid+1;
            }else if (arr[mid] < arr[mid-1]&&arr[mid] > arr[mid+1]){
                high = mid -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        int[] arr2 = {18,29,38,59,98,100,99,98,90};
        int[] arr3 = {3,5,3,2,0};
        System.out.println(new Solution().peakIndexInMountainArray(arr3));
    }

    public int peakIndexInMountainArray2(int[] A) {
        // 1.[定左右]
        int l = 0;
        int r = A.length-1;

        // 2.[定区间]
        while (l <= r) {// [l,r]
            // 3.[取中值]
            int mid = l + (r-l)/2;

            // 4.[进退]
            if (A[mid+1] > A[mid]) {// 上坡
                l = mid + 1; // [爬坡]
            } else if (A[mid-1] > A[mid]){// 下坡
                r = mid - 1; // [返回坡顶]
            } else {
                return mid;
            }

        }

        // 5.[无功而返]
        return -1;
    }
}






