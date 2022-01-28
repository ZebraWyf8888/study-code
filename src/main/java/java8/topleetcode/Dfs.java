package java8.topleetcode;

import sun.plugin.javascript.navig.LinkArray;

import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Dfs {
    public static void dfsWithStack(TreeNode root){
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (stack.isEmpty()){
            TreeNode poll = stack.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                stack.push(poll.left);
            }
            if (poll.right != null) {
                stack.push(poll.right);
            }
        }

    }
}
