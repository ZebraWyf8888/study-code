package macleetcode.day0203;


import macleetcode.tree.TreeNode;

import java.util.HashMap;

/**
 * @author wyf
 */


public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res=false;
        if(A!=null&&B!=null){
            if(A.val==B.val){
                res=doesHaveSub(A,B);
            }
            if(res!=true){
                res=isSubStructure(A.left,B);
            }
            if(res!=true){
                res=isSubStructure(A.right,B);
            }
        }
        return res;
    }

    public boolean doesHaveSub(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return doesHaveSub(A.left, B.left)&&doesHaveSub(A.right, B.right);
    }


    int[] preorder ;
    HashMap<Integer,Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            dic.put(inorder[i], i);

        }
        return  recur(0,0,inorder.length-1);
    }

    /**
     * @param  root 先序遍历的索引
     * @param  left 中序遍历的索引
     * @param  right 中序遍历的索引
     */
    private TreeNode recur(int root, int left, int right) {
        if (left>right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        treeNode.left = recur(root+1, left, i-1);
        treeNode.right = recur(root+i-left+1, i+1,right );
        return treeNode;
    }
}
