package note;

import java.util.HashMap;
import java.util.Map;

/**
* @Author: WYF
* @Description: 找两个数字之和为某一个数字，关键在于考虑如何让找的效率更高
 * 这里利用哈希表
* @Create: 2020/3/6 21:57
* @Version: 1.0
*/
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
