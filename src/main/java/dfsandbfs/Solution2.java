package dfsandbfs;



import java.util.*;

/**
 * @Description: 非递归压栈，实现深度优先遍历
*/
public class Solution2 {
    /**
     * 深度优先就是先序遍历
     * @param root
     */
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

    /**
     * 中序遍历
     * @param root
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> objects = new LinkedList<>();
        objects.push(root);
        while (root != null|| objects.isEmpty()){
            while (root != null){
                root = root.left;
                objects.push(root);
            }
            TreeNode pop = objects.pop();
            ans.add(pop.val);
            if (pop.right != null) {
                objects.push(pop.right);
            }
        }
        return ans;
    }
}
