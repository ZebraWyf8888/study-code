package day20220206;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int sumOfUnique(int[] nums) {
        Integer ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer: nums) {
            Integer value = map.getOrDefault(integer,0);
            if (value == 0) {
                ans += integer;
                map.put(integer,1);
            }else if (value == 1){
                ans -= integer;
                map.put(integer,2);
            }
        }
        return ans;
    }
    public int sumOfUnique2(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) count[num]++;
        int res = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] == 1) res += i;
        }
        return res;
    }
}
