package day20220215;

import java.util.ArrayList;
import java.util.List;

/**
 *1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 返回所有幸运数，其实答案只有0个或者1个两种情况，如果存在的话一定是所有最小值中的最大值，或者换一种说法，所有最大值中的最小值。
 * 证明一下，假如答案多余一个，设为matrix[x1][y1]和matrix[x2][y2]，根据题意，matrix[x1][y2] > matrix[x1][y1]（行最小），matrix[x1][y2] < matrix[x2][y2]（列最大）推出matrix[x1][y1] < matrix[x2][y2]；matrix[x2][y1] < matrix[x1][y1]（列最大），matrix[x2][y1] > matrix[x2][y2]（行最小）推出matrix[x1][y1] > matrix[x2][y2]，这矛盾了
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int idx = 0;
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowMIn = Integer.MAX_VALUE;
            int rowIdx = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowMIn > matrix[i][j]) {
                    rowIdx = j;
                    rowMIn = matrix[i][j];
                }
            }
            if (rowMIn > value) {
                idx = rowIdx;
                value = rowMIn;
            }
        }

        ArrayList<Integer> objects = new ArrayList<>();

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][idx] > value) {
                return objects;
            }
        }
        objects.add(value);
        return objects;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] arr1= new int[][]{
                {3,7,8},
                {9,11,13},
                {15,16,17}};

        int [][] arr=new int[][]{{4,5,6,8},{2,3},{1,6,9}};

        int [][] arr2= new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        solution.luckyNumbers(arr2);

    }
}
