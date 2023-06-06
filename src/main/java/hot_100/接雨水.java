package hot_100;

import java.util.LinkedList;

/**
 * 接雨水
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/28 01:20
 */
public class 接雨水 {
    /***
     * 双指针法
     * 分解为求每根柱子的接水量：等于左边最高柱子和右边最高柱子的最小值减去本身柱子高度，所得值就是高，宽固定为1
     * 注意第一根柱子和最后一个柱子接水量为0，直接跳过不处理
     *
     * 因为遍历每个元素的时候，还要向两边寻找最高的列，所以时间复杂度为O(n^2)。空间复杂度为O(1)
     */
//    public int trap(int[] height) {
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (i == 0 || i == height.length - 1) {
//                continue;
//            }
//            int leftMax = 0;
//            int rightMax = 0;
//            // 求当前柱子左边柱子最高高度
//            for (int left = 0; left < i; left++) {
//                leftMax = Math.max(leftMax, height[left]);
//            }
//            // 求当前柱子右边柱子最高高度
//            for (int right = height.length - 1; right > i; right--) {
//                rightMax = Math.max(rightMax, height[right]);
//            }
//            // 求当前柱子接水量
//            int temp = (Math.min(leftMax, rightMax) - height[i]) * 1;
//            if (temp > 0) {
//                // 有可能小于0，则不加入到总和sum中
//                sum += temp;
//            }
//
//        }
//        return sum;
//    }

    /***
     * 双指针法
     * 分解为求每根柱子的接水量：等于左边最高柱子和右边最高柱子的最小值减去本身柱子高度，所得值就是高，宽固定为1
     * 注意第一根柱子和最后一个柱子接水量为0，直接跳过不处理
     *
     * 为了减少时间复杂度，提前把每个元素的左边列最高高度和右边列最高高度算出来后保存，避免重复计算
     * 所以时间复杂度为O(n)。空间复杂度为O(n)
     */
//    public int trap(int[] height) {
//        // 用来存放每个元素左边列最高高度和右边列最高高度
//        // 例如下标为1的元素，左边列最高高度为leftArr[1]，右边列最高高度为right[1]
//        // 当前位置，左边的最高高度是前一个位置的左边最高高度和本高度的最大值
//        int leftArr[] = new int[height.length];
//        int rightArr[] = new int[height.length];
//        // 对于第一个元素，左边列最高高度等于本身
//        leftArr[0] = height[0];
//        for (int i = 1; i < height.length; i++) {
//            leftArr[i] = Math.max(leftArr[i - 1], height[i]);
//        }
//        // 对于最后一个元素，右边列最高高度等于本身
//        rightArr[height.length - 1] = height[height.length - 1];
//        for (int i = height.length - 2; i >= 0; i--) {
//            rightArr[i] = Math.max(rightArr[i + 1], height[i]);
//        }
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (i == 0 || i == height.length - 1) {
//                continue;
//            }
//            // 求当前柱子接水量
//            int temp = (Math.min(leftArr[i], rightArr[i]) - height[i]) * 1;
//            if (temp > 0) {
//                // 有可能小于0，则不加入到总和sum中
//                sum += temp;
//            }
//
//        }
//        return sum;
//    }

    /***
     * 单调栈解法
     * 思路：首先我们应该考虑什么情况下才能接到雨水，只有当出现凹槽的时候，才能接到雨水
     *      那么什么情况下才出现凹槽，就是当元素先减后增的情况下，才可能出现凹槽，我们从凹这个字也可以体会出来
     *      凡是涉及元素递增递减问题，就可以考虑使用单调栈解决
     *      对于单调栈来说，一般说的就是栈顶到栈底是单调递增还是单调递减，具体看题目而定
     *      如果新加入的元素破坏了单调栈的特性，那么就需要弹出元素直至符合单调栈
     *
     *      在本题中，由于只有当元素先减后增的情况，才可能出现凹槽接到雨水，因此这里的单调栈我们使用栈顶到栈底单调递增
     *      如果新加入元素小于当前栈顶元素，符合条件，直接入栈
     *      如果新加入元素等于当前栈顶元素，需要更新栈顶元素，因为栈中存放的是元素下标，
     *      后面在计算接水量的时候，会使用到下标，所以如果后面元素等于栈顶元素，需要将栈顶元素更新为当前元素下标
     *      如果新加入元素大于栈顶元素，破坏单调栈，其实也代表出现凹槽，需要计算接水量
     *      （注意：计算一个凹槽的接水量，需要基于三根柱子才能算出来）
     */
    public int trap(int[] height) {
        // 注意栈中存放的是元素的下标
        LinkedList<Integer> stack = new LinkedList<>();
        // 第一个元素入栈
        stack.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] > height[stack.peek()]) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 出栈
                    int temp = stack.pop();
                    // 基于当前元素和刚出栈的元素以及当前栈顶元素三根柱子计算接水量
                    if (!stack.isEmpty()) {
                        // 注意这里需要多一层判断，否则可能空指针
                        int high = Math.min(height[i], height[stack.peek()]) - height[temp];
                        int width = i - stack.peek() - 1;
                        sum += high * width;
                    }

                }
                stack.push(i);
            } else {
                // 更新栈顶元素
                stack.pop();
                stack.push(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = new 接雨水().trap(arr);
        System.out.println(res);
    }
}
