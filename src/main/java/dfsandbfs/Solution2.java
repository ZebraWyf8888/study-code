package dfsandbfs;



import leetcode20220116.ListNode;
import macleetcode.tree.TreeNode;

import java.util.*;

/**
 * @Description: 非递归压栈，实现深度优先遍历
*/
public class Solution2 {
    /**
     * 深度优先就是先序遍历
     * @param root
     */
    public static void dfsWithStack(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node treeNode = stack.pop();
            /**
             * @Description: 处理当前节点
            */
            System.out.println(treeNode.value);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left == null) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 中序遍历
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     *
     * 空间复杂度：O(n)O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)O(n) 的级别。
     *
     * @param root
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     *  Morris 中序遍历
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉搜索树的节点个数。Morris 遍历中每个节点会被访问两次
     * ，因此总时间复杂度为 O(2n)=O(n)O(2n)=O(n)。
     *
     * 空间复杂度：O(1)O(1)。
     *其实整个过程我们就多做一步：假设当前遍历到的节点为 xx，
     * 将 xx 的左子树中最右边的节点的右孩子指向 xx，
     * 这样在左子树遍历完成后我们通过这个指向走回了 xx，
     * 且能通过这个指向知晓我们已经遍历完成了左子树，而不用再通过栈来维护，省去了栈的空间复杂度。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null){
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
     *
     * 1\如果 xx 无左孩子，先将 xx 的值加入答案数组，再访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
     * 2\如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），我们记为 \textit{predecessor}predecessor。根据 \textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
     *  2.1如果 predecessor 的右孩子为空，则将其右孩子指向 xx，
     *      然后访问 xx 的左孩子，即 x = x.{left}x=x.left。
     *  2.2如果 predecessor 的右孩子不为空，则此时其右孩子指向 xx，
     *      说明我们已经遍历完 xx 的左子树，我们将 {predecessor}predecessor
     *      的右孩子置空，将 xx 的值加入答案数组，然后访问 xx 的右孩子，
     *      即 x = x.\textit{right}x=x.right。
     *
     * 作者：LeetCode-Solution.java
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode p = null;
        while (root != null){
            if (root.left != null) {
                //predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                p = p.left;
                while (p.right != null && p.right !=root){
                    p = p.right;
                }
                //让 predecessor 的右指针指向 root，继续遍历左子树
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                //说明左子树已经访问完了，我们需要断开链接
                }else {
                    res.add(root.val);
                    p.right = null;
                    root = root.right;
                }
            //如果没有左孩子，则直接访问右孩子
            }else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode p = null;
        while (root != null){
            if (root.left != null) {
                p = p.left;
                while (p.right != null && p.right != root){
                    p = p.right;
                }
                //让 predecessor 的右指针指向 root，继续遍历左子树
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                    //说明左子树已经访问完了，我们需要断开链接
                }else {
                    ans.add(root.val);
                    p.right = null;
                    root = root.right;
                }
            }else {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal5(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode p = null;
        while (root != null){
            if (root.left != null) {
                p = p.left;
                while (p.right != null && p.right != root){
                    p = p.right;
                }
                if (root.right == null) {
                    p.right = root;
                    root = root.left;
                }else {
                    ans.add(root.val);
                    p.right = null;
                    root = root.right;
                }

            }else {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
