package ahot;

import leetcode.二叉树.TreeNode;

import java.util.*;

/**
 * 树的遍历相关
 * 深度优先：
 *      前序：递归、非递归
 *      中序：递归、非递归
 *      后序：递归、非递归
 * 广度优先：
 *      非递归的层次遍历
 *
 *  N叉树，前后序遍历
 *
 *  重建二叉树
 *
 */
public class 树的遍历相关 {
    /**
     * 前序
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            /**
             * @Description: 处理当前节点
             */
            ans.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return ans;
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
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 后序
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root !=null || !stack.isEmpty() ){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            //从栈中弹出的元素，左子树一定是访问完了的
            root = stack.pop();
            //现在需要确定的是是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了（也就是上一个访问的节点是右子节点时）
            //说明可以访问当前节点
            if (root.right == null || root.right == pre) {
                ans.add(root.val);
                //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                pre = root;
                root = null;
            }else {
                //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }

    /**
     * 层次
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }

    /**
     * 递归的
     *
     *
     * @Description: 求最大深度
     * @Param: [treeNode]：节点
     * @Return: int：每个节点的最大深度
     * @Author: WYF
     * @Date: 2020/4/18 15:10
     */
    public static int getMaxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(treeNode.left) + 1;
        int rightDepth = getMaxDepth(treeNode.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }


    /**
     * Morris (中序)遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
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

    List<Integer> ans = new ArrayList<>();
    List<Node> stack = new ArrayList<>();

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * n叉树后序
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null) return ans;
        Node temp = root;
        stack.add(temp);
        while(stack.size() > 0) {
            temp = stack.remove(stack.size() - 1);
            ans.add(temp.val);

            for(Node child : temp.children){
                stack.add(child);
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
