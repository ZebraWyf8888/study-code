package leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/1 02:02
 */
public class 二叉树的所有路径 {

    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            backtracking(root);
        }
        return result;
    }

    private void backtracking(TreeNode node) {
        // 先处理根节点
        path.add(String.valueOf(node.val));
        // 递归终止的条件：当前节点为叶子节点
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    sb.append(path.get(i));
                } else {
                    sb.append(path.get(i)).append("->");
                }
            }
            result.add(sb.toString());
            return;
        }
        // 递归处理左子树
        if (node.left != null) {
            backtracking(node.left);
            // 递归和回溯一一对应，递归一次，回溯一次
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            // 递归处理右子树
            backtracking(node.right);
            // 递归和回溯一一对应，递归一次，回溯一次
            path.remove(path.size() - 1);
        }
    }
}
