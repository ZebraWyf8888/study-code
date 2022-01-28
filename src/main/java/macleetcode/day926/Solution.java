package macleetcode.day926;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// * Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(root,sum,0,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int now, ArrayList<Integer> list, List<List<Integer>> ans) {
        //如果节点为空直接返回
        if (root == null) {
            return;
        }
        //把当前节点值加入到list中,第一步
        list.add(new Integer(root.val));
        //每往下走一步就要计算走过的路径和
        now += root.val;
        //如果到达叶子节点，判断是不是所要的链表，是就返回
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，now == sum。说明找到了，放入list，
            if (now == sum) {
                /**
                 * todo:注意这里不要踩坑，如果直接把list放进去，java都是传的引用，都是同一个list
                 */
                ans.add(new ArrayList(list));
            }
            //后面要，return，
            // 可能其父亲节点，还有其他孩子要计算，所以移除当前点
            list.remove(list.size()-1);
            //走不动了
            return;
        }
        //没到叶子点，继续往下找，其中sum、list、ans都是有状态的，这也是要remove的原因
        dfs(root.left,sum,now,list,ans);
        dfs(root.right,sum,now,list,ans);
        //递归 最后也是要往回走的
        list.remove(list.size()-1);
    }
}


