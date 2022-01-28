package macleetcode.code3.com.offer;

import java.util.Arrays;

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //构建二叉树
        TreeNode treeNode = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        postOrderTraverse(treeNode);

        //下面是递归遍历二叉树的
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode23 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode32 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode21;
        treeNode2.right = treeNode23;

        treeNode3.right = treeNode32;

        //proOrderTraverse(treeNode1);
    }

    //先序遍历——递归实现
    public static void proOrderTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            visiteNode(treeNode);//访问当前节点
            proOrderTraverse(treeNode.left);//左节点访问
            proOrderTraverse(treeNode.right);//右节点访问
        }
    }

    //后序遍历——递归实现
    public static void postOrderTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            proOrderTraverse(treeNode.left);//左节点访问
            proOrderTraverse(treeNode.right);//右节点访问
            visiteNode(treeNode);//访问当前节点
        }
    }

    private static void visiteNode(TreeNode treeNode) {
        if(treeNode == null){
            System.out.println("This node is empty.");
        }else {
            System.out.println(treeNode.val);
        }
    }


}
