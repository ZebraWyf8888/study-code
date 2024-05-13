package note.leetcode;

//import com.sun.javafx.tools.packager.MakeAllParams;

public class dp {
    public int lengthOfLIS(int[] nums) {
       if(nums.length == 0){
           return 0;
       }
        int[] dp = new int[nums.length];
       /**
        * @Description:
       */
        int maxans = 1;
        for (int i = 0; i < dp.length; i++) {
            int value = 0;
            /**
             * @Description: 从头到尾，在前面的dp中找一个最大的
            */
            for (int j = 0; j < i; j++) {
                value = Math.max(value, dp[j]);
            }
            dp[i] = maxans + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    /**
     * @Description: 上面的动态规划，时间为O（n^2）,空间O(n)
     * 下面采用贪心+二分查找
     */


/**
 作者：LeetCode-Solution.java
 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
}
