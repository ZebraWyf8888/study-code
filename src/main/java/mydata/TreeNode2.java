package mydata;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TreeNode2 {
    public int val;
    public TreeNode2 left;
    public TreeNode2 right;

    public TreeNode2() {
    }

    public TreeNode2(int val) {
        this.val = val;
    }

    public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode2 initBinaryTree(Integer... TreeNode2Values) {
        if (TreeNode2Values == null) {
            throw new IllegalArgumentException("TreeNode2Values should not be null");
        }
        int nodeCount = TreeNode2Values.length;
        if (nodeCount == 0) {
            throw new IllegalArgumentException("TreeNode2Values count should not be zero");
        }
        if (TreeNode2Values[0] == null) {
            return null;
        }
        TreeNode2 root = new TreeNode2(TreeNode2Values[0]);
        List<TreeNode2> list = new LinkedList<>();
        list.add(root);
        int index = 1;
        while (!list.isEmpty()) {
            TreeNode2 node = list.remove(0);
            if (node == null) {
                continue;
            }
            if (index < nodeCount) {
                TreeNode2 left = TreeNode2Values[index] == null ? null : new TreeNode2(TreeNode2Values[index]);
                node.left = left;
                list.add(left);
                index++;
            }
            if (index < nodeCount) {
                TreeNode2 right = TreeNode2Values[index] == null ? null : new TreeNode2(TreeNode2Values[index]);
                node.right = right;
                list.add(right);
                index++;
            }
        }
        if (index != nodeCount) {
            throw new IllegalArgumentException("TreeNode2Values can not utils.init a binary utils.tree");
        }
        return root;
    }

    public TreeNode2 getNode(int target) {
        return findNode(this, target);
    }

    private TreeNode2 findNode(TreeNode2 root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        TreeNode2 leftResult = findNode(root.left, target);
        return leftResult != null ? leftResult : findNode(root.right, target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode2 TreeNode2 = (TreeNode2) o;
        return val == TreeNode2.val && Objects.equals(left, TreeNode2.left) && Objects.equals(right, TreeNode2.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        List<String> result = new LinkedList<>();
        List<TreeNode2> list = new LinkedList<>();
        list.add(this);
        while (!list.isEmpty()) {
            TreeNode2 node = list.remove(0);
            result.add(node == null ? "null" : String.valueOf(node.val));
            if (node != null) {
                list.add(node.left);
                list.add(node.right);
            }
        }
        int index = result.size() - 1;
        while (index > 0 && "null".equals(result.get(index))) {
            result.remove(index--);
        }
        return result.toString();
    }
}
