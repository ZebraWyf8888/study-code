package ahot;

import leetcode.二叉树.TreeNode;

public class 树的子结构 {
    /**
     当节点 BB 为空：说明树 BB 已匹配完成（越过叶子节点），因此返回 truetrue ；
     当节点 AA 为空：说明已经越过树 AA 叶子节点，即匹配失败，返回 falsefalse ；
     当节点 AA 和 BB 的值不同：说明匹配失败，返回 falsefalse ；

     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
