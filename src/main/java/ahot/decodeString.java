package ahot;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class decodeString {


}
class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        int n = chs.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(chs[i] - '0' >= 0 && chs[i] - '0' <= 9) { // 遇到数字
                int num = 0;
                while(chs[i] - '0' >= 0 && chs[i] - '0' <= 9){ // 截取数字
                    num = num * 10 + chs[i] - '0';
                    i++;
                }
                numStack.push(num);
            }
            if(chs[i] == '[') strStack.push(String.valueOf(chs[i])); // 遇到 '[' 推入字符串栈
            else if(chs[i] == ']'){ // 遇到 ']'
                StringBuilder curSb = new StringBuilder();
                while(!strStack.peek().equals(String.valueOf('['))){ // 拼接 '[' 之前的字符串
                    curSb.insert(0, strStack.pop());
                }
                strStack.pop(); // 推出 '['
                int k = numStack.pop(); // 推出数字
                String repeatedStr = repeate(curSb.toString(), k); // 重复 k 次
                strStack.push(repeatedStr); // 然后推入字符串栈
            }
            else strStack.push(String.valueOf(chs[i]));
        }
        StringBuilder res = new StringBuilder();
        while(!strStack.isEmpty()){
            res.insert(0, strStack.pop());
        }
        return res.toString();
    }
    private String repeate(String s, int k){ // 倍增拼接 (快速幂思想)
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        while(k > 0){
            if(k % 2 == 1) res = res.append(sb);
            sb = sb.append(sb);
            k /= 2;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.decodeString("HG[3|B[2|CA]]F");
        System.out.println(s);
    }
}
//
//作者：力扣官方题解
//        链接：https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。