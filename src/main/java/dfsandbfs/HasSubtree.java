package dfsandbfs;

import java.util.LinkedList;

//错误，不是在同一棵树上找
//https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?f=discussion

/**
 * @Author: WYF
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @Create: 2020/5/5 12:02
 * @Version: 1.0
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            //TODO:处理节点
            if (pop == root2) {
                return true;
            }

            //TODO:左节点压栈
            if (pop.left != null) {
                stack.push(pop.left);
            }
            //TODO:右节点压栈
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return false;
    }
}
