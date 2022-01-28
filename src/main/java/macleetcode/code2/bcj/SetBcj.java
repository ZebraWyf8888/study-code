package macleetcode.code2.bcj;

/**
* @Author: WYF
* @Description: https://baijiahao.baidu.com/s?id=1651803445417553212&wfr=spider&for=pc
 * 并查集问题
* @Create: 2020/4/28 22:31
* @Version: 1.0
*/
public class SetBcj {
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
    public SetBcj(int num) {
        int[] ints = new int[num];
        count = ints.length;
        //把每个人设置为-1，自己就是自己的父亲，最大
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }
    /**
     * @Description: 有向图的情况
     * 把root1作为root2的父节点
     * @Param: [root1, roo2]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/28 22:26
    */
    public void union(int root1,int roo2){
        s[roo2] = root1;
    }
    /**
     * @Description: 查找最父亲的节点
     * @Param: [x]
     * @Return: int
     * @Author: WYF
     * @Date: 2020/4/28 22:27
    */
    public int find(int x){
        if (s[x] < 0) {
            //就是-1的情况，自己是父亲
            return x;
        }else {
            //不是，返回自己的父亲，让父节点去找父节点
            return find(s[x]);
        }
    }
}
