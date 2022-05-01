package day20220501;


import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString(){
        return Integer.toString(val);
    }

    //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String []strs = str.split(",");
        int []arr = new int[strs.length];

        for (int i = 0; i < arr.length; i++) {
            if (strs[i].equals("null")) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }

        return arr;
    }

    //    String str = "[3,9,20,null,null,15,7]";
    public static TreeNode mkTree(String str) {

        int []arr = StrToIntArray(str);
        TreeNode[]nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            }else {
                nodes[i] = null;
            }
        }

        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }

}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorderTraversal(root1);
        List<Integer> list2 = inorderTraversal(root2);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0,j=0; i < list1.size() || j < list2.size();) {
            Integer integer1 = Integer.MAX_VALUE;
            Integer integer2 = Integer.MAX_VALUE;
            if (i < list1.size()) {
                integer1 = list1.get(i);
            }
            if (j < list2.size()) {
                integer2 = list2.get(j);
            }

            if (integer1 < integer2) {
                ans.add(integer1);
                i++;
            }else {
                ans.add(integer2);
                j++;
            }
        }

        return ans;
    }

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

    public static void main(String[] args) {
        String str1 = "[2,1,4]";
        String str2 = "[1,0,3]";
        TreeNode node1 = TreeNode.mkTree(str1);
        TreeNode node2 = TreeNode.mkTree(str2);
        Solution solution = new Solution();

        List<Integer> allElements = solution.getAllElements(node1, node2);

        for (Integer a:
             allElements) {
            System.out.println(a);
        }


    }
}