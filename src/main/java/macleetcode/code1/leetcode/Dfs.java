package macleetcode.code1.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * @Description: 递归深度优先遍历，找最大半径
 * @Param:
 * @Return:
 * @Author: WYF
 * @Date: 2020/4/12 1:24
 */
public class Dfs {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root);
        int rightDepth = dfs(root);
        res = Math.max(res, leftDepth+rightDepth+1);
        return Math.max(leftDepth, rightDepth)+1;
    }
}
