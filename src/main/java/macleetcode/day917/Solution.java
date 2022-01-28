package macleetcode.day917;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param N int整型
     * @return string字符串
     */
    public String baseNeg2(int N) {
        // write code here
        if (N == 0) {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        while (N != 0) {
            int r = N % (-2);
            s.append(r == -1 ? 1 : r);
            N = N / (-2);
            if (r == -1) {
                N++;
            }
        }
        return "\"" + s.reverse().toString() + "\"";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.movingCount(2, 3, 1);
        System.out.println(i);

    }

    private boolean isok(int i, int j, int k) {
        int he = 0;

        while (i != 0) {
            he += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            he += j % 10;
            j = j / 10;
        }
        if (he > k) {
            return false;
        } else {
            return true;
        }

    }


    int count2 = 0;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 移动的次数
     *
     * @param m int整型
     * @param n int整型
     * @param k int整型
     * @return int整型
     */
    public int movingCount(int m, int n, int k) {
        int count = 0;
        int[][] ints = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = 1;
                if (isok(i, j, k)) {
                    count++;
                }
            }
        }

        digui(ints,0,0,m,n);


        return count2;
    }

    private void digui(int[][] ints, int i, int j,int m ,int n) {
        if (ints[i][j] == 0) {
            return;
        }
        count2++;

        if (i-1<m&&i-1>0) {
            digui(ints,i-1,j,m,n);
        }
        if (i+1<m&&i+1>0) {
            digui(ints,i+1,j,m,n);
        }

        if (j-1<n&&j-1>0) {
            digui(ints,i,j-1,m,n);
        }
        if (j+1<n&&j+1>0) {
            digui(ints,i,j+1,m,n);
        }
    }
}