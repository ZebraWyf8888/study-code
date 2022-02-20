package day20220220;

import macleetcode.day1119.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * 二叉树每层的最大值，两种方法 bfs非递归 dfs递归
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                max = Math.max(max,node.val);
            }
            ans.add(max);
        }
        return ans;
    }

    List<Integer> ans2 = new ArrayList<>();
    public List<Integer> largestValues2(TreeNode root) {
        dfs(root,0);
        return ans2;
    }

    private void dfs(TreeNode root,int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans2.size()) {
            ans2.add(Integer.MIN_VALUE);
        }
        ans2.set(depth,Math.max(root.val,ans2.get(depth)));
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }


    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, 0);
        return result;
    }


    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 首次遍历第 depth 层，向 result 中添加一个值以增加其长度方便与 set 值
        if (depth == result.size()) {
            result.add(Integer.MIN_VALUE);
        }
        result.set(depth, Math.max(result.get(depth), root.val));
        depth++;
        traverse(root.left, depth);
        traverse(root.right, depth);
    }

}
