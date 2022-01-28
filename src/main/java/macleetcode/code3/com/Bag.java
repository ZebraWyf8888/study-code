package macleetcode.code3.com;

public class Bag {
    public static void main(String[] args) {
        int[] va={0,3,4,5,6};
        int[] w={0,2,3,4,5};
        int c = 8;
        int[][] a = new int[5][9];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 9; j++) {
                if (j >= w[i]) {
                    if (a[i-1][j] > a[i-1][j-w[i]]+va[i]) {
                        a[i][j] = a[i-1][j];
                    }else {
                        a[i][j] = a[i-1][j-w[i]]+va[i];
                    }
                }else {
                    a[i][j] = a[i-1][j];
                }
            }
        }

//        for (int i = 1; i < 5; i++) {
//            for (int j = 1; j < 9; j++) {
//                if (w[i] > j) {
//                    a[i][j] = a[i-1][j];
//                }else {
//                    if (a[i-1][j-w[i]]+va[i]>a[i-1][j]) {
//                        a[i][j] = a[i-1][j-w[i]]+va[i];
//                    }else {
//                        a[i][j] = a[i-1][j];
//                    }
//                }
//            }
//        }

        System.out.println(a[4][c]);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
