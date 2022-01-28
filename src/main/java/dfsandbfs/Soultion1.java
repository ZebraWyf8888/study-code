package dfsandbfs;

/**
* @Author: WYF
* @Description: 递归，深度优先遍历
* @Create: 2020/4/18 11:49
* @Version: 1.0
*/
public class Soultion1 {
    public static void dfs(Node treeNode){
        if (treeNode == null) {
            return;
        }
        /**
         * @Description: 处理节点
        */
        System.out.println(treeNode.value);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
