package macleetcode.code2.dfsandbfs;


import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * @Author: WYF
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Create: 2020/5/5 11:39
 * @Version: 1.0
 */
public class MirrorTree {

    /**
     * @Author: WYF
     * @Description: 方法一，递归遍历树(深度优先遍历)
     * @Create: 2020/5/5 11:40
     * @Version: 1.0
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * @Author: WYF
     * @Description: 方法一，非递归实现(广度优先遍历)
     * @Create: 2020/5/5 11:40
     * @Version: 1.0
     */
    public void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode son = queue.poll();
            TreeNode temp = son.left;
            son.left = son.right;
            son.right = temp;
            if (son.left != null) {
                queue.offer(son.left);
            }
            if (son.right != null) {
                queue.offer(son.right);
            }
        }
    }


}
