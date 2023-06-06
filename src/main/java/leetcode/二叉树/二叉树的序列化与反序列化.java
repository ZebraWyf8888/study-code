package leetcode.二叉树;


import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 *
 * 单单依靠二叉树某种遍历结果是不能还原二叉树结构的，因为缺少空指针的信息；
 * 至少要得到前、中、后序遍历中的两种才能还原二叉树；
 * 或者是某种遍历结果中包含了空指针的信息
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/8 00:28
 */
public class 二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    // 使用前序遍历二叉树，并且插入空节点的信息
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表，使用LinkedList方便移除列表的第一个元素
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> list) {
        if (list.size() == 0) {
            return null;
        }
        String first = list.removeFirst();
        if (first.equals("null")) {
            return null;
        }
        // 根据前序遍历的特性，列表的第一个元素为根节点
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
