package p1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @Author: WYF
* @Description: 矩阵旋转
* @Create: 2020/5/2 0:34
* @Version: 1.0
*/

public class Solution {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        Solution solution = new Solution();
        List<Integer> integers = solution.printMatrix(a);
        System.out.println(integers.toString());
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list  = new ArrayList<Integer>();
        //TODO:定义四个边界
        int left = 0;
        int right = matrix[0].length;
        int up = 0;
        int down = matrix.length;
        //TODO:定义当前索引
        int x = 0;
        int y = 0;
        //TODO:定义次数
        int temp = 1;
        int time = (right)*(down);
        right--;
        down--;

        if (time == 1) {
            list.add(matrix[0][0]);
            return list;
        }
        while(temp < time){

            while(temp <= time &&y<right){
                list.add(matrix[x][y]);
                temp++;
                y++;
            }

            while(temp <= time && x<down){
                list.add(matrix[x][y]);
                temp++;
                x++;
            }

            while(temp <= time &&y>left){
                list.add(matrix[x][y]);
                temp++;
                y--;
            }

            while(temp <= time &&x>up){
                list.add(matrix[x][y]);
                temp++;
                x--;
            }


            left++;
            right--;
            up++;
            down--;

            /**调整位置，进入下一圈*/
            x++;y++;


            //防止m = n 是正方形的情况最后一个数字
            if(temp == time) {
                list.add(matrix[x][y]);
            }
        }
        return list;
    }

}