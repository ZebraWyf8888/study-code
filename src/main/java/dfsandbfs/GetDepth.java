package dfsandbfs;

/**
 * @Author: WYF
 * @Description: 求最大/最小深度
 * @Create: 2020/4/18 14:55
 * @Version: 1.0
 */
public class GetDepth {
    /**
     * @Description: 求最大深度
     * @Param: [treeNode]：节点
     * @Return: int：每个节点的最大深度
     * @Author: WYF
     * @Date: 2020/4/18 15:10
     */
    public static int getMaxDepth(Node treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(treeNode.left) + 1;
        int rightDepth = getMaxDepth(treeNode.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * @Description: 求最最小深度
     * @Param: [treeNode]：节点
     * @Return: int：每个节点的最小深度
     * @Author: WYF
     * @Date: 2020/4/18 15:10
     */
    public static int getMinDepth(Node treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getMinDepth(treeNode.left) + 1;
        int rightDepth = getMinDepth(treeNode.right) + 1;
        return Math.min(leftDepth, rightDepth);
    }
}
