package java8.topleetcode;

import java.util.LinkedList;

public class Bfs {
    public static void dfsWithStack(TreeNode root){
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

    }
}
