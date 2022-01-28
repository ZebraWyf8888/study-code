package macleetcode.code2.dfsandbfs;

import java.util.LinkedList;
import java.util.Stack;

public class TestTree {
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (stack.size() != 0) {
            TreeNode now = stack.pop();
            System.out.println(now.val);
            if (now.left != null) {
                stack.add(now.left);
            }
            if (now.right != null) {
                stack.add(now.right);
            }
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}