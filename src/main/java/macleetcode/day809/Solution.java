package macleetcode.day809;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 返回最少需要多少辆车
     * @param trips int整型二维数组 二维int数组，用于表示一组乘客的行程信息，其中`trip[i]`表示第i组乘客，`trip[i][0]`表示第i组乘客的乘客数量，`trip[i][1]`表示上车站点，`trip[i][2]`表示下车站点。
     * @param capacity int整型 int类型，表示每辆车最多能承载多少名乘客
     * @return int整型
     */
    /*public int minCarCount (int[][] trips, int capacity) {
        // write code here
        int count = 0;
        return count;
    }*/

    /**
     * int，返回做完x个任务后能达到的最高等级
     * @param x int整型 需要完成的任务数量
     * @param level int整型 初始等级
     * @param tasks int整型二维数组 表示可供选择的任务，tasks[i][0]表示第i个任务所需的最低等级，task[i][1]表示第i个任务完成后能提升的等级
     * @return int整型
     */
//    public int maxLevel (int x, int level, int[][] tasks) {
//        int ans = level;
//        for (int i = 0; i < x; i++) {
//            int maxFix = 0;
//            for (int j = 0; j < tasks.length; j++) {
//                if (tasks[j][0]<=level && tasks[j][1]>tasks[maxFix][1]) {
//                   maxFix = j;
//                }
//            }
//            ans +=tasks[maxFix][1];
//            tasks[maxFix][0] = 0;
//            tasks[maxFix][1] = 0;
//        }
//        return ans;
//    }



    public int maxLevel (int x, int level, int[][] tasks) {
       int[][] ans = new int[x+1][tasks.length+1];
        int maxLevel = 0;
        for (int i = 1; i <= x; i++) {
            maxLevel = 0;
            for (int j = 1; j <= tasks.length; j++) {
//                if ()

                if (maxLevel>=ans[j][0]) {
                    ans[i][j] = maxLevel+tasks[j-1][1];
                    if (ans[i][j] >maxLevel) {
                        maxLevel = ans[i][j];
                    }
                }
            }
        }
        return ans[x][tasks.length];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{0,1};
        int[] ints2 = new int[]{1,2};
        int[] ints3 = new int[]{1,3};
        int[][] intsbil = new int[3][];
        intsbil[0] = ints1;
        intsbil[1] = ints2;
        intsbil[2] = ints3;
        int i = solution.maxLevel(2, 1, intsbil);
        System.out.println(i);
    }
}
