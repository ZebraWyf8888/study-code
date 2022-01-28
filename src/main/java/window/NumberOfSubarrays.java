package window;

/**
* @Author: WYF
* @Description: https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/hua-dong-chuang-kou-qian-zhui-he-bi-xu-miao-dong-b/
 * 滑动窗口，找有多少个子串满足条件：包含奇数个k
 * 滑动窗口的场景必须是连续的，不能是离散的，abcde，找abc这种，不是abd
* @Create: 2020/4/22 0:09
* @Version: 1.0
*/
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        //左右指针
        int left = 0,right = 0;
        //oddcnt，当前的奇数个数;res,子集数量
        int oddCnt = 0 ,res = 0;
        while (right<nums.length){
            //右边先走，找到奇数++oddcnt；
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }
            //  若当前滑动窗口 [left, right) 中有 k 个奇数了，
            // 进入此分支统计当前滑动窗口中的优美子数组个数。
            if(oddCnt == k){
                // 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
                // rightEvenCnt 即为第 k 个奇数右边的偶数的个数
                int temp = right;
                while (right<nums.length&&(nums[right]&1) == 0){
                    right++;
                }
                //计算第k个奇数，右边有多少个偶数
                int rightEvenCnt = right - temp;


                //计算第1个奇数（选取的第一个），左边有多少个偶数
                temp = left;
                while ((nums[left] & 1) == 0){
                    left++;
                }
                int leftEvenCnt = left-temp;

                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;

            }
        }
        return res;
    }
}
