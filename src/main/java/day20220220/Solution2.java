package day20220220;

import macleetcode.day1119.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

    /**
     * 递归
     * 二叉数的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = getMaxDepth(root.left, depth + 1);
        int right = getMaxDepth(root.right, depth + 1);
        return Math.max(right, left);
    }

    /**
     * 递归
     * 二叉数的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if(root.left != null) {
            ans = Math.min(getMinDepth(root.left), ans);
        }
        if(root.right != null) {
            ans = Math.min(getMinDepth(root.right), ans);
        }
        return ans;
    }

    static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 非递归
     * 二叉数的最小深度
     * 包一个节点，里面加深度，当左右为空，
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

}
