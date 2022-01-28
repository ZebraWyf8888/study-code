package dfsandbfs;

import java.util.ArrayList;
import java.util.List;

/**
* @Author: WYF
* @Description: 102题目，用深度优先遍历解决
* @Create: 2020/4/18 11:49
* @Version: 1.0
*/
public class LeetCode102Dep implements Cloneable {
    private static final List<List<Integer>> TRAVERSAL_LIST  = new ArrayList<>();
    public static void dfs(Node treeNode,int level){
        if (treeNode == null) {
            return;
        }
        if (TRAVERSAL_LIST.size() < level + 1) {
            TRAVERSAL_LIST.add(new ArrayList<>());
        }

        List<Integer> levelList = TRAVERSAL_LIST.get(level);
        levelList.add(treeNode.value);

        // 遍历左结点
        dfs(treeNode.left, level + 1);

        // 遍历右结点
        dfs(treeNode.right, level + 1);
    }
}
