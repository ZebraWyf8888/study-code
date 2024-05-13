package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/4 15:11
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inorderTraversal(root, list);
    }
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        // 递归遍历左子树
        inorderTraversal(root.left, list);
        list.add(root.val);
        // 递归遍历右子树
        inorderTraversal(root.right, list);
        return list;
    }

    /***
     * 非递归解法，依靠栈实现
     * 处理方式和先序遍历有所差异，因为先序遍历是访问的节点和要处理的节点顺序一致，也就是先访问中间节点，也是先处理中间节点
     * 但是中序遍历是先访问中间节点，但是先处理的是左节点
     *
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
