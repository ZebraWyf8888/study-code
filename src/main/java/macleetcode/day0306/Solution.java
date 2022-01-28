package macleetcode.day0306;


import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最大牛奶桶数
     * @param grass int整型一维数组 吃的草的捆数
     * @param milk int整型一维数组 产的牛奶桶数
     * @return int整型
     */
    public static int MaxMilk (int[] grass, int[] milk) {
        // write code here

        int[][] isfight = new int[milk.length][milk.length];
        for (int i = 0; i < grass.length; i++) {
            for (int j = i+1; j < grass.length; j++) {
                if ((grass[i] >grass[j]&&milk[i]<milk[j])||(grass[i] <grass[j]&&milk[i]>milk[j])) {
                    isfight[j][i] = 1;
                    isfight[i][j] = 1;
                }
            }
        }
        int max = 0;

        for (int i = 0; i < grass.length; i++) {
            int ans = milk[i];
            for (int j = 1; j < 4; j++) {
                if (isfight[i][(i+j)%4] == 0) {
                    ans += milk[(i+j)%4];
                }
            }
            if (ans >= max) {
                max = ans;
            }


        }
        return  max;
    }
    public static void main(String[] args) {
        int[] arr1 =new int[]{3,5,8,2};
        int[] arr2 =new int[]{2,3,5,7};
        int i1 = MaxMilk(arr1, arr2);
        System.out.println(i1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        for (int i = 0; i < adj.length; i++) {
            Arrays.fill(adj[i], -1);
        }

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        while (true){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int len = sc.nextInt();
            if (i == 0&&j == 0 && len ==0) {
                break;
            }
            adj[i][j] = len;
            adj[j][i] = len;
        }
         getShortestPaths(adj);
        System.out.println(result[a2]);
    }
    static int[] result;
    /*
     * 参数adjMatrix:为图的权重矩阵，权值为-1的两个顶点表示不能直接相连
     * 函数功能：返回顶点0到其它所有顶点的最短距离，其中顶点0到顶点0的最短距离为0
     */
    public static int[] getShortestPaths(int[][] adjMatrix) {
        result = new int[adjMatrix.length];   //用于存放顶点0到其它顶点的最短距离
        boolean[] used = new boolean[adjMatrix.length];  //用于判断顶点是否被遍历
        used[0] = true;  //表示顶点0已被遍历
        for (int i = 1; i < adjMatrix.length; i++) {
            result[i] = adjMatrix[0][i];
            used[i] = false;
        }

        for (int i = 1; i < adjMatrix.length; i++) {
            int min = Integer.MAX_VALUE;    //用于暂时存放顶点0到i的最短距离，初始化为Integer型最大值
            int k = 0;
            for (int j = 1; j < adjMatrix.length; j++) {  //找到顶点0到其它顶点中距离最小的一个顶点
                if (!used[j] && result[j] != -1 && min > result[j]) {
                    min = result[j];
                    k = j;
                }
            }
            used[k] = true;    //将距离最小的顶点，记为已遍历
            for (int j = 1; j < adjMatrix.length; j++) {  //然后，将顶点0到其它顶点的距离与加入中间顶点k之后的距离进行比较，更新最短距离
                if (!used[j]) {  //当顶点j未被遍历时
                    //首先，顶点k到顶点j要能通行；这时，当顶点0到顶点j的距离大于顶点0到k再到j的距离或者顶点0无法直接到达顶点j时，更新顶点0到顶点j的最短距离
                    if (adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1))
                        result[j] = min + adjMatrix[k][j];
                }
            }
        }
        return result;
    }
}