package macleetcode.code2.bcj;

/**
* @Author: WYF
* @Description: https://zhuanlan.zhihu.com/p/93647900
 * 并查集问题，改进优化，路径压缩
* @Create: 2020/4/28 22:31
* @Version: 1.0
*/
public class SetBcjTwo {
    /**
     * 表示每个节点的父节点，只有一个
     */
    private int[] s;
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
    public SetBcjTwo(int num) {
        int[] ints = new int[num];
        count = ints.length;
        //把每个人设置为-1，自己就是自己的父亲，最大
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
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
        int min = Math.min(froot1, froot2);
        s[froot1+froot2-min] = min;
        //选父亲的标准，索引越小的节点，他就越有权力当父亲
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
