package dfsandbfs;

import macleetcode.tree.TreeNode;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

}
