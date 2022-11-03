package day20211225;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];

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

        int[] arr = StrToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
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


/**
 * 广度优先（层次遍历）
 */
public class Solution {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val % 2 != 1) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (queue.size() != 0) {
            boolean desc = level % 2 == 1 ? true : false;
            int temp = -1;
            int size = queue.size();
            boolean isFirstCom = true;
            boolean isFirstComDone = false;
            TreeNode firstNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                if (!isFirstComDone) {
                    firstNode = left;
                    isFirstComDone = true;
                }

                if (left != null) {
                    queue.offer(left);
                    if (isFirstCom && firstNode == null) {
                        return false;
                    } else {
                        isFirstCom = false;
                    }
                    if (temp == -1) {
                        temp = left.val;
                    } else {
                        if (isFirstCom && firstNode == null) {
                            return false;
                        } else {
                            isFirstCom = false;
                        }
                        if (desc) {
                            if (left.val % 2 != 0) {
                                return false;
                            }
                            if (left.val >= temp) {
                                return false;
                            } else {
                                temp = left.val;
                            }
                        } else {
                            if (left.val % 2 != 1) {
                                return false;
                            }
                            if (left.val <= temp) {
                                return false;
                            } else {
                                temp = left.val;
                            }
                        }
                    }
                }
                TreeNode right = poll.right;
                if (right != null) {
                    queue.offer(right);
                    if (isFirstCom && firstNode == null) {
                        return false;
                    } else {
                        isFirstCom = false;
                    }
                    if (temp == -1) {
                        temp = right.val;
                    } else {

                        if (desc) {
                            if (right.val % 2 != 0) {
                                return false;
                            }
                            if (right.val >= temp) {
                                return false;
                            } else {
                                temp = right.val;
                            }
                        } else {
                            if (right.val % 2 != 1) {
                                return false;
                            }
                            if (right.val <= temp) {
                                return false;
                            } else {
                                temp = right.val;
                            }
                        }
                    }
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {

        //[1,10,4,3,null,7,9,12,8,6,null,null,2]
//        mydata.TreeNode treeNode1 = new mydata.TreeNode(1);
//        mydata.TreeNode treeNode10 = new mydata.TreeNode(10);
//        mydata.TreeNode treeNode4 = new mydata.TreeNode(4);
//        mydata.TreeNode treeNode3 = new mydata.TreeNode(3);
//        mydata.TreeNode treeNode7 = new mydata.TreeNode(7);
//        mydata.TreeNode treeNode9 = new mydata.TreeNode(9);
//        mydata.TreeNode treeNode12 = new mydata.TreeNode(12);
//        mydata.TreeNode treeNode8 = new mydata.TreeNode(8);
//        mydata.TreeNode treeNode6 = new mydata.TreeNode(6);
//        mydata.TreeNode treeNode2 = new mydata.TreeNode(2);
//
//        treeNode1.left = treeNode10;
//        treeNode1.right = treeNode4;
//        treeNode10.left = treeNode3;
//        treeNode3.left = treeNode12;
//        treeNode3.right = treeNode8;
//        treeNode4.left = treeNode7;
//        treeNode4.right = treeNode9;
//        treeNode7.left = treeNode6;
//        treeNode9.right = treeNode2;


//        String str = "[11,12,8,3,7,11,null,null,null,20]";
//        mydata.TreeNode node = mydata.TreeNode.mkTree(str);
//        boolean evenOddTree = isEvenOddTree(node);
//        System.out.println(evenOddTree);


        String s1 = "[11,12,8,3,7,11,null,null,null,20]";
        //需要返回true；
        //String s2 = "[11,18,14,3,7,null,null,null,null,18,null]";
        //需要返回false
        TreeNode node1 = TreeNode.mkTree(s1);
        //mydata.TreeNode node2 = mydata.TreeNode.mkTree(s2);
        boolean evenOddTree1 = isEvenOddTree(node1);
        System.out.println(evenOddTree1);
        //boolean evenOddTree2 = isEvenOddTree(node2);
     //   System.out.println(evenOddTree2);
    }


    public boolean  isEvenOddTree2(TreeNode root) {

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                int val = node.val;

                if (val%2 == level%2) {
                    return false;
                }
                if ((level%2 == 0 && val<=prev) ||(level%2 == 1 && val>=prev)) {
                    return false;
                }
                prev = val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }

        return true;
    }


}