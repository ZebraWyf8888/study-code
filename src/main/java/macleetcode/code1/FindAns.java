package macleetcode.code1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindAns {
    /**
     * @Description:窗口滑动
     * @Param: [s] ：查找的字符串
     * @Return: int：输出最长无重复子串大小
     * @Author: WYF
     * @Date: 2020/3/8 12:20
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * @Description: 优化滑动优化
     * @Param: [s] ：查找的字符串
     * @Return: int：输出最长无重复子串大小
     * @Author: WYF
     * @Date: 3.11 -21点45分
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (j < n && i < n) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j++), j);
                count = Math.max(j-i, count);
            }else {
                i = Math.max(i, map.get(s.charAt(j)));
                map.put(s.charAt(j++), j);
                count = Math.max(j-i, count);
            }
        }
        return count;
    }

    /**
     * @Description: 优化滑动优化+数组代替map
     * @Param: [s] ：查找的字符串
     * @Return: int：输出最长无重复子串大小
     * @Author: WYF
     * @Date: 3.11 -21点45分
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);//算法核心是理解这个，对s.charAt(j)是不是已经有数据的判断
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
