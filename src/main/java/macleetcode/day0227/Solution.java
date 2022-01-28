package macleetcode.day0227;

import java.util.HashMap;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
public class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character,int[]> time = new HashMap();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            boolean b = time.containsKey(aChar);
            if (b) {
                int[] ints = time.get(aChar);
                ints[0] = ints[0]++;
                if (ints[0] == 3) {
                    return i-ints[1]+1;
                }
            }else {
                int[] a = {1,i};
                time.put(aChar, a);
            }
        }
        return 0;
    }
}
