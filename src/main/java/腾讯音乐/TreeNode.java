package 腾讯音乐;

/**
 * 二叉树的定义
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/7 00:34
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
