package dfsandbfs;

import java.util.*;

/**
* @Author: WYF
* @Description: 给你一个二叉树，请你返回其按层序遍历得到的节点值。
 * 问题的关键在于遍历同一层节点前，必须事先算出同一层的节点个数有多少
* @Create: 2020/4/18 15:14
* @Version: 1.0
*/
public class LeetCode102 {
    public static List<List<Integer>> bfs(Node root){
        if (root == null) {
            // 根节点为空，说明二叉树不存在，直接返回空数组
            return Arrays.asList();
        }
        List<List<Integer>> restlt = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            // 记录每一层
            List<Integer> level = new ArrayList<>();
            int levelNum = queue.size();
            // 遍历当前层的节点
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.value);
            }
            restlt.add(level);
        }
        return restlt;
    }
}
