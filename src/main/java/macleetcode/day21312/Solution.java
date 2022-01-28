package macleetcode.day21312;

import macleetcode.day1119.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    //
    //验证二叉树的前序序列化
    public boolean isValidSerialization(String preorder) {


        String[] split = preorder.split(",");

        int slot = 1;
        for (int i = 0; i < split.length; i++) {
            if (slot == 0) {
                return false;
            }
            if (split[i].equals("#")){
                slot--;
            } else {
                slot ++;
            }
        }
//
        return slot ==0;
    }




        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }


}
