package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/7 00:34
 */
public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        // 递归遍历左子树
        preorder(root.left, list);
        // 递归遍历右子树
        preorder(root.right, list);
    }

    /***
     * 非递归解法，依靠栈实现
     *
     * 根节点先入栈，只要栈不为空，则不断弹出栈顶元素，并且先将弹出节点的右节点入栈，然后再左节点入栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 出栈
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            // 若右节点不为空，则入栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            // 若左节点不为空，则入栈
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return list;
    }
}
