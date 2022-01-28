package recall;

import java.util.ArrayList;
import java.util.List;

public class BackTrack {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int[] visit = new int[nums.length];
        backtrack(res,nums,new ArrayList<Integer>(),visit);
        return res;
    }

    private void backtrack( List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visit) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visit);
            visit[i] = 0;
            temp.remove(temp.size()-1);
        }
    }
}
