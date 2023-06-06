package leetcode.二叉树;

import java.util.Arrays;

/**
 * 最大二叉树
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/3/12 16:18
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        // 查找数组中最大元素的下标值
        int maxIndex = getMaxIndex(nums);
        // 创建根节点
        TreeNode root = new TreeNode(nums[maxIndex]);
        // 递归创建左子树
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        // 递归创建右子树
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return root;
    }

    // 查找数组中最大元素的下标值
    private int getMaxIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
