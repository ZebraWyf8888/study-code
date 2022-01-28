package dfsandbfs;



import java.util.Stack;

/**
 * @Description: 非递归压栈，实现深度优先遍历
*/
public class Soultion2 {
    public static void dfsWithStack(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

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
            if (treeNode.left == null) {
                stack.push(treeNode.left);
            }
        }
    }
}
