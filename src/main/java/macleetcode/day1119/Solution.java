package macleetcode.day1119;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        solution.preorderTraversal(null);
    }
    ArrayList<Integer> ans = new ArrayList<Integer>();

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode treeNode = stack.pop();
            //System.out.println(treeNode.val);
            ans.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return ans;
    }

    public int romanToInt(String s) {

        return 0;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> characterIntegerHashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            characterIntegerHashMap.put(ch, characterIntegerHashMap.getOrDefault(ch, 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            characterIntegerHashMap.put(ch, characterIntegerHashMap.getOrDefault(ch, 0)-1);
            if (characterIntegerHashMap.get(ch) == 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tree = stack.pop();
            list.add(tree.val);

            if(tree.right != null){
                stack.push(tree.right);
            }
            if(tree.left != null){
                stack.push(tree.left);
            }
        }
        return list;
    }
}