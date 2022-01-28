package macleetcode.code2.bcj;

/**
* @Author: WYF
* @Description: 上一个版本中，我们对父亲节点的选取
 * 就是索引越小的节点，他就越有权力当父亲
 * 其实这并不合理，处于效率，我们应该选：
 * 深度小的节点作为子节点
 * 深度大的节点作为父节点
 * 查找起来也比较快
 * 多了一个深度的概念
 *
 * 注：rank只是参考值，不准确
* @Create: 2020/4/29 0:04
* @Version: 1.0
*/
public class SetBcjThree {
    /**
     * 表示每个节点的父节点，只有一个
     */
    private int[] s;

    /**
     * 表示每个节点的深度
     */
    private int[] rank;
    /**
     * @Description: 总结点数量
     */
    private int count;

    /**
     * @Description: 构造函数
     * @Param: num
     * @Author: WYF
     * @Date:
     */
    public SetBcjThree(int num) {
        int[] ints = new int[num];
        count = ints.length;
        //把每个人设置为-1，自己就是自己的父亲，最大
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
            //一开始深度为1
            rank[i] = 1;
        }
    }
    /**
     * @Description: 无向图
     * 注意，其实无向图的情况，并查集无法保存图的全部数据
     * @Param: [root1, roo2]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/28 22:26
     */
    public void union(int root1,int root2){
        int froot1 = find(root1);
        int froot2 = find(root2);
        int add = 0;
        if (rank[froot2] >= rank[froot1]) {
            s[froot1] = froot2;
            add = froot2;
        }else {
            s[froot2] = froot1;
            add = froot1;
        }
        if (rank[froot1] == rank[froot2] && froot1!= froot2) {
            /**
             * 如果深度相同且根节点不同，则新的根节点的深度+1
             */
            rank[add]++;
        }
    }
    /**
     * @Description: 查找最父亲的节点
     * @Param: [x]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/4/28 22:27
     */
    public int find(int x){
        if (s[x] == x) {
            //就是x的情况，自己是父亲
            return x;
        }else {
            s[x] = find(s[x]);  //父节点设为根节点
            return s[x];         //返回父节点
        }
    }
    //通过上面的操作，以后我们要判断两个点是不是相连，判断是不是父节点一样就好
    //https://zhuanlan.zhihu.com/p/93647900
}
