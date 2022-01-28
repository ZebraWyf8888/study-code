package dfsandbfs;

import java.util.*;

/**
* @Author: WYF
* @Description: 广度优先
 * 深度优先遍历用栈。广度优先遍历用队列
* @Create: 2020/4/18 14:47
* @Version: 1.0
*/
public class Solution3 {
    public static void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()){
            Node node = stack.poll();
            /**
             * @Description: 处理当前节点
            */
            System.out.println(node.value);
            Node left = node.left;
            if (left == null) {
                stack.add(left);
            }

            Node right = node.right;
            if (right == null) {
                stack.add(right);
            }
        }
    }
}
