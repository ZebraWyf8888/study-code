package leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/7 00:34
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 递归遍历左子树
        postorder(root.left, list);
        // 递归遍历右子树
        postorder(root.right, list);
        list.add(root.val);
    }

    /***
     * 非递归解法，依靠栈实现
     *
     * 先序遍历是中左右，后序遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，
     * 然后在反转result数组，输出的结果顺序就是左右中了
     *
     * 也就是说，还是使用先序遍历非递归解法，只不过是先将弹出节点的左节点入栈，然后再右节点入栈；
     * 最后再将结果列表进行反转
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        // 根节点入栈1
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            // 出栈的节点值存放到栈2
            stack2.push(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        // 最后，将栈2的值一一出栈放到结果list中
        List<Integer> list = new ArrayList<>();
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }
}
