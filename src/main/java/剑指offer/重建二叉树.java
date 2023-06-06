package 剑指offer;

import java.util.Arrays;

/**
 * 重建二叉树
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 11:44
 */
public class 重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 先序遍历数组的第一个节点为根节点
        int val = preorder[0];
        // 找出根节点再先序遍历数组的位置，用一个遍历记录该下标
        int temp = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                temp = i;
                break;
            }
        }
        // 创建一个根节点
        TreeNode root = new TreeNode(val);
        // 递归构建根节点的左子树
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + temp), Arrays.copyOfRange(inorder, 0, temp));
        // 递归构建根节点的左子树
        root.right = buildTree(Arrays.copyOfRange(preorder, temp + 1, preorder.length), Arrays.copyOfRange(inorder, temp + 1, inorder.length));
        return root;
    }
}
