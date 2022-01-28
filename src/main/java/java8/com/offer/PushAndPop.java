package java8.com.offer;

import java.util.Stack;


//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class PushAndPop {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    //    错误，此处多此一举，不应该一进来就马上压入stack2
//    public int pop() {
//        if (!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        int x = stack2.pop();
//        if (!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
//        return x;
//    }

    //一个栈负责压入，一个负责弹出，弹出加以处理，想过在压入的时候加以处理，但是没能实现
    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        }else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
