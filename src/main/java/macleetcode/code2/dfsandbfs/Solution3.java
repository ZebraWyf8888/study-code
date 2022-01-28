package macleetcode.code2.dfsandbfs;

import java.util.*;

/**
* @Author: WYF
* @Description: 广度优先
 * 深度优先遍历用栈。广度优先遍历用队列
* @Create: 2020/4/18 14:47
* @Version: 1.0
*/
public class Solution3 {
    public  void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode TreeNode = stack.poll();
            /**
             * @Description: 处理当前节点
            */
            System.out.println(TreeNode.val);
            TreeNode left = TreeNode.left;
            if (left != null) {
                stack.add(left);
            }

            TreeNode right = TreeNode.right;
            if (right != null) {
                stack.add(right);
            }
        }
    }
}
