package day20220228;

import macleetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        List<int[]> ans = new ArrayList<>();
        // write code here
        TreeNode r = root;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> mid = new ArrayList<>();
        while (!stack.isEmpty() || r != null){
            while (r != null){
                stack.push(r);
                r = r.left;
            }
            TreeNode pop = stack.pop();
            mid.add(pop.val);
            r = pop.right;
        }
        Integer[] midIne = mid.toArray(new Integer[0]);


        ArrayList<Integer> f = new ArrayList<>();
        dfs(root,f);
        Integer[] fInt = f.toArray(new Integer[0]);


        ArrayList<Integer> last = new ArrayList<>();
        postOrderTraverse(root,last);
        Integer[] lastInt = last.toArray(new Integer[0]);


        int[] ints2 = Arrays.stream(fInt).mapToInt(Integer::intValue).toArray();
        int[] ints1 = Arrays.stream(midIne).mapToInt(Integer::intValue).toArray();
        int[] ints = Arrays.stream(lastInt).mapToInt(Integer::intValue).toArray();

        ans.add(ints2);
        ans.add(ints1);
        ans.add(ints);


        return ans.toArray(new int[0][]);
    }

    private void dfs(TreeNode root, ArrayList<Integer> f) {
        if (root == null) {
            return;
        }
        f.add(root.val);
        dfs(root.left,f);
        dfs(root.right,f);
    }

    //后序遍历——递归实现
    public static void postOrderTraverse(TreeNode treeNode,ArrayList<Integer> last) {
        if (treeNode != null) {
            postOrderTraverse(treeNode.left,last);//左节点访问
            postOrderTraverse(treeNode.right,last);//右节点访问
            last.add(treeNode.val);
        }
    }
}