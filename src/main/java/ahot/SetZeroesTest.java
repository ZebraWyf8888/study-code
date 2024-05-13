package ahot;


import java.util.Arrays;

public class SetZeroesTest {
    public static void main(String[] args) {
// 创建测试矩阵
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 0},
//                {7, 8, 9}
//        };

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };


// 输出原始矩阵
        System.out.println("原始矩阵：");
        printMatrix(matrix);

// 调用方法进行处理
        SetZeroesTest.setZeroes(matrix);

// 输出处理后的矩阵
        System.out.println("处理后的矩阵：");
        printMatrix(matrix);
    }

    // 输出矩阵的方法
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }


        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

        }

        for (int i = m - 1; i >= 0; i--) {
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
