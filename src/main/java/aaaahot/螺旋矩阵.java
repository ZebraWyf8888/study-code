package aaaahot;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public int[][] generateMatrix(int n) {
        if(n==0) return null;
        int[][]  result = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int numEle = n  * n;
        int num = 1;
        while (numEle >= num) {
            for (int i = left; i <= right && numEle >= num; i++) {
                result[top][i] =num;
                num++;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= num; i++) {

                result[i][right] =num;
                num++;
            }
            right--;
            for (int i = right; i >= left && numEle >= num; i--) {
                result[bottom][i] =num;
                num++;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= num; i--) {
                result[i][left] =num;
                num++;
            }
            left++;
        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix==null||matrix.length==0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;

        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }
}
