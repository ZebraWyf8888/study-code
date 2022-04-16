package ahot;

import java.util.HashMap;

public class 最长无重复子串 {
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
}
