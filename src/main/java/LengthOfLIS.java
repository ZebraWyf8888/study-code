//https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //TODO:tail[i] 表示nums中前i个的元素中，它的最长递增子序列的最小结尾，比如，5687， 递增是567/568，但最小是结尾应该是7
        int[] tails = new int[nums.length];
        //TODO:tail[i] 并不是要求的子序列
        int res = 0;
        for (int num : nums) {
            //TODO:新进来的num都需要放到tail中，只是放的位置不同，根据位置不同，决定res（要求的答案，长度）要不要递增
            int i = 0, j = res;
            //TODO:在nums中找一个位置，用num替代，要求此位置上的数字：1.大于num 2.此数字在此数字最小
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            //TODO:j指针没变化，说明当前数字num 大于 前几位的结尾的最小值（tail[i]），长度可以增加
            if (res == j) {
                res++;
            }
        }
        return res;
    }

    /*public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num:nums) {
            int i = 0,j = res;
            while (i<j){
                int m = (i+j)/2;
                if (tail[m]<num) {
                    i = m+1;
                }else {
                    j = m;
                }
            }
            tail[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }*/
}
