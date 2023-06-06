package 腾讯音乐;

import java.util.ArrayList;

/**
 * 题目描述
 * 已知一个二叉树的先序遍历序列和中序遍历序列，但其中一些节点的值可能相同。请你返回所有满足条件的二叉树。二叉树在数组中的顺序是任意的。
 *
 * 相比于剑指offer-18 重建二叉树有值重复的结点
 *
 * 样例
 * 输入例子：
 * [1,1,2],[1,2,1]
 * 输出例子：
 * [{1,1,#,#,2},{1,#,1,2}]
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 13:22
 */
public class 带重复节点的前序中序二叉树 {
    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder,
                                              ArrayList<Integer> inOrder) {
        // write code here
        return recur(preOrder, inOrder, 0, preOrder.size() - 1, 0, inOrder.size() - 1);
    }

    private ArrayList<TreeNode> recur(ArrayList<Integer> preOrder,
                                      ArrayList<Integer> inOrder,
                                      int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {

        //在上一个递归中，可能分别在代码50，54出现leftNodeNumber与rightNodeNumber 均为0的情况，此时无法形成一棵二叉树
        if (preOrderLeft > preOrderRight || inOrderLeft > inOrderRight)
            return new ArrayList<>();
            //出现一个节点作为子树情况
        else if (preOrderLeft == preOrderRight && inOrderLeft == inOrderRight) {
            if (preOrder.get(preOrderLeft).equals(inOrder.get(inOrderLeft))) {
                TreeNode node = new TreeNode(preOrder.get(preOrderLeft));
                ArrayList<TreeNode> res = new ArrayList<>();
                res.add(node);
                return res;
            }
        }
        ArrayList<TreeNode> root = new ArrayList<>();
        //遍历中序遍历中的节点，找到与curRoot相同值的位置，并以此作为当前根节点，继续递归。
        for (int i = inOrderLeft; i <= inOrderRight;
             i++) { //i为中序遍历中作为根结点的点
            if (inOrder.get(i).equals(preOrder.get(preOrderLeft))) {
                int leftNodeNumber = i - inOrderLeft;
                int rightNodeNumber = inOrderRight - i;

                //得到左子树能够获得树
                ArrayList<TreeNode> leftTree = recur(preOrder, inOrder,
                        preOrderLeft + 1, preOrderLeft + leftNodeNumber,
                        inOrderLeft, i - 1);
                //得到右子树能够获得的树叶
                ArrayList<TreeNode> rightTree = recur(preOrder, inOrder,
                        preOrderRight - rightNodeNumber + 1, preOrderRight,
                        i + 1, i + rightNodeNumber);
                //没有元素构成左子树时
                if (leftNodeNumber == 0) {
                    for (TreeNode rightNode : rightTree) {
                        //选择preOrderLeft的位置为1
                        TreeNode curRoot = new TreeNode(preOrder.get(preOrderLeft));
                        curRoot.right = rightNode;
                        root.add(curRoot);
                    }
                    //没有元素构成右子树时
                } else if (rightNodeNumber == 0) {
                    for (TreeNode leftNode : leftTree) {
                        //选择preOrderLeft的位置为1
                        TreeNode curRoot = new TreeNode(preOrder.get(preOrderLeft));
                        curRoot.left = leftNode;
                        root.add(curRoot);
                    }
                    //所有左子树*所有右子树，需要对子树进行深拷贝
                } else {
                    for (TreeNode leftNode : leftTree)
                        for (TreeNode rightNode : rightTree) {
                            TreeNode left = copy(leftNode);
                            TreeNode right = copy(rightNode);
                            //选择preOrderLeft的位置为1
                            TreeNode curRoot = new TreeNode(preOrder.get(preOrderLeft));
                            curRoot.left = left;
                            curRoot.right = right;
                            root.add(curRoot);
                        }
                }

            }
        }
        return root;
    }

    //对root进行深拷贝，并返回一个深拷贝后的节点
    private TreeNode copy(TreeNode root) {
        if (root == null)
            return null;
        TreeNode curRoot = new TreeNode(root.val);
        curRoot.left = copy(root.left);
        curRoot.right = copy(root.right);
        return curRoot;
    }
}
