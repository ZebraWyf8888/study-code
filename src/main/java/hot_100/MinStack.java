package hot_100;

import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2022/6/9 00:50
 */
public class MinStack {

    private LinkedList<Integer> linkedList;
    private Integer minValue;

    public MinStack() {
        linkedList = new LinkedList();
    }

    public void push(int val) {
        if (linkedList.isEmpty()) {
            minValue = val;
        } else {
            minValue = val < minValue ? val : minValue;
        }
        linkedList.push(val);
    }

    public void pop() {
        linkedList.pop();
    }

    public int top() {
        return linkedList.poll();
    }

    public int getMin() {
        return minValue;
    }
}
