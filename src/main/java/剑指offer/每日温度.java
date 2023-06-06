package 剑指offer;

import java.util.LinkedList;

/**
 * 每日温度
 *
 * 什么是单调栈：
 *  就是栈里面的元素保持单调递增或者单调递减，不符合条件则需要出栈，直至符合条件再入栈
 *  顺序一般为：栈顶到栈底
 *
 * 什么情况用单调栈：
 *  通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，
 *  此时我们就要想到可以用单调栈了
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/4/17 01:13
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 创建一个栈，当做单调栈来用
        // 栈里面存放的必须是下标，如果存放当前元素本身，那么出栈的时候不好计算两个元素之间的下标差值
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        // 第一个元素下标值入栈
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            // 如果当前要入栈的元素值大于栈顶元素，那么违反单调栈的特性，需要出栈，直至符合条件才可入栈
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 栈顶元素出栈，说明找到比他大的元素了，可以计算栈顶元素下标和此时遍历到的元素下标的差值
                int index = stack.pop();
                result[index] = i - index;
            }
            // 不管是否符合上面while的条件，当前元素下标都得入栈
            stack.push(i);
        }
        return result;
    }
}

