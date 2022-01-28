package macleetcode.code2.dfsandbfs;



import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: 非递归压栈，实现深度优先遍历
*/
public class Solution2 {
    public static void dfsWithStack(Node root){
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<Node>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node treeNode = stack.pop();
            /**
             * @Description: 处理当前节点
            */
            System.out.println(treeNode.value);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }


}
