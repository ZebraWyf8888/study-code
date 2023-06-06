package ahot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int length = s.length();
        Boolean[] booleans = new Boolean[length];
        booleans[0] = Boolean.TRUE;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (booleans[j] && wordDictSet.contains(s.substring(j,i))) {
                    booleans[i] = Boolean.TRUE;
                    break;
                }
            }
        }
        return booleans[length-1];
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
