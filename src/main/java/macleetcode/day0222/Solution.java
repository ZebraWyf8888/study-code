package macleetcode.day0222;
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int x = 0,y = 0; x < matrix.length-1; x++) {
            int temp = matrix[x][y];
            for (int index = 1;x+index<matrix[0].length&&y+index<matrix.length;index++){
                if (temp != matrix[x+index][y+index]) {
                    return false;
                }
            }
        }

        for (int x = 0,y = 1; y < matrix[0].length-1; y++) {
            int temp = matrix[x][y];
            for (int index = 1;x+index<matrix[0].length&&y+index<matrix.length;index++){
                if (temp != matrix[x+index][y+index]) {
                    return false;
                }
            }
        }
        return true;
    }
}