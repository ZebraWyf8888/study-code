package day20220214;

import java.util.HashMap;

public class Solution2 {
    /**
     * 最长无重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left,map.get(chars[i]) + 1);
            }
            map.put(chars[i],i);
            ans = Math.max(ans,i - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                left = Math.max(left,map.get(aChar)+1);
            }
            map.put(aChar,i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
