package aaaahot;

import java.util.HashSet;

public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (Integer num : nums) {
            hashSet.add(num);
        }
        int ans = 0;
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
