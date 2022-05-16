package ahotreview;

import macleetcode.tree.TreeNode;

import java.util.*;

/**
 * 树的遍历相关
 * 深度优先：
 *      前序：递归、非递归
 *      中序：递归、非递归
 *      后序：递归、非递归
 * 广度优先：
 *      非递归的层次遍历
 *
 *  N叉树，前后序遍历
 *
 *  重建二叉树
 *
 */
public class 树的遍历相关 {

    int[] pre;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0, 0, inorder.length-1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left < right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[root]);
        int i = dic.get(pre[root]);

        node.left = recur(root + 1, left,i - 1);
        node.right = recur(root + i - left + 1,i + 1, right);

        return node;
    }

}
