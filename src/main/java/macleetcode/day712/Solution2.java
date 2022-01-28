package macleetcode.day712;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author wangyifan
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double d = -Double.MAX_EXPONENT;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val<=d) {
                return false;
            }

            d = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(-1);

        TreeNode treeNode = new TreeNode(0);
        treeNode.left = treeNode1;

        Solution2 solution2 = new Solution2();
        solution2.isValidBST(treeNode);
    }
}