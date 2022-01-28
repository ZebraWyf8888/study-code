package macleetcode.code2.dfsandbfs;

import macleetcode.by.dfs;

import java.util.*;

/**
* @Author: WYF
* @Description: 给你一个二叉树，请你返回其按层序遍历得到的节点值。
 * 问题的关键在于遍历同一层节点前，必须事先算出同一层的节点个数有多少
* @Create: 2020/4/18 15:14
* @Version: 1.0
*/
public class LeetCode102 {
    public static List<List<Integer>> bfs(TreeNode root){
        if (root == null) {
            // 根节点为空，说明二叉树不存在，直接返回空数组
            return Arrays.asList();
        }
        List<List<Integer>> restlt = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;
        while (!queue.isEmpty()){
            // 记录每一层
            List<Integer> level = new ArrayList<>();
            int levelNum = queue.size();
            // 遍历当前层的节点
            flag = !flag;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = null;
                if (flag) {
                    node = queue.pollLast();
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }else {
                    node = queue.pollFirst();
                    //tree.TreeNode node = queue.poll();


                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }

                level.add(node.val);
            }
            restlt.add(level);
        }
        return restlt;
    }

    public static void main(String[] args) {
        //下面是递归遍历二叉树的
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode31 = new TreeNode(4);
        TreeNode treeNode32 = new TreeNode(5);
        TreeNode treeNode33 = new TreeNode(6);
        TreeNode treeNode34 = new TreeNode(7);

        TreeNode treeNode41 = new TreeNode(8);
        TreeNode treeNode42 = new TreeNode(9);
        TreeNode treeNode43 = new TreeNode(10);
        TreeNode treeNode44 = new TreeNode(11);
        TreeNode treeNode45 = new TreeNode(12);
        TreeNode treeNode46 = new TreeNode(13);
        TreeNode treeNode47 = new TreeNode(14);
        TreeNode treeNode48 = new TreeNode(15);

        treeNode1.left = treeNode21;
        treeNode1.right = treeNode22;

        treeNode21.left = treeNode31;
        treeNode21.right = treeNode32;

        treeNode22.left = treeNode33;
        treeNode22.right = treeNode34;

        treeNode31.left = treeNode41;
        treeNode31.right = treeNode42;
        treeNode32.left = treeNode43;
        treeNode32.right = treeNode44;
        treeNode33.left = treeNode45;
        treeNode33.right = treeNode46;
        treeNode34.left = treeNode47;
        treeNode34.right = treeNode48;

        Solution3 solution3 = new Solution3();
        solution3.bfs(treeNode1);


        System.out.println("----------");
        List<List<Integer>> bfs = bfs(treeNode1);
        for (List<Integer> a:
             bfs) {
            for (Integer a1:
                 a) {
                System.out.print(a1);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
