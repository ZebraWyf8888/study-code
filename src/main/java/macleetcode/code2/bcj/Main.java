package macleetcode.code2.bcj;

import java.util.Scanner;

/**
 * @Author: WYF
 * @Description: 无向图判断是否连通，并查集
 * @Create: 2020/4/28 23:06
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] fa = new int[N + 1];
        for (int i = 0; i < N; i++) {
            fa[i] = i;
        }
        /**
         *记录并的次数
         */
        int num = N;
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int uf = fa[u];
            int vf = fa[v];
            while (fa[uf] != u){
                uf = fa[uf];
            }
            while (fa[v] != v){
                vf = fa[vf];
            }
            //属于不同子集的合并起来
            if (uf != vf) {
                int min = Math.min(uf, vf);
                //uf与vf中总有一个是min，剩下就是一个father节点
                fa[uf + vf - min] = min;
                num--;
            }
        }
        System.out.println(num == 1?"YES":"NO");
        sc.close();
    }
}
