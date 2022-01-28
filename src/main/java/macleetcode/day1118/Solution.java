package macleetcode.day1118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int canCompleteCircuit(int[] gas,int[] cost){
        int n = gas.length;
        int i = 0;
        while (i<n){
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;
            while (cnt<n){
                int j = (i + cnt)%n;
                sumOfCost += cost[j];
                sumOfGas += gas[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt ++;
            }

            if (cnt == n){
                return i;
            }else {
                i = i +cnt +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        canCompleteCircuit(gas, cost);
    }

    public List<String> generateParenthesis(int n){
       List<String> ans =  new ArrayList<String>();
        backtrack(ans,new StringBuilder(),0,0,n);
       return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max ) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() -1 );
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() -1);
        }
    }
}
