package note.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1;//表示入队的队列
    Queue<Integer> q2;
    int top ;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1){//精髓，只留下一个，出队
            top= q1.remove();
            q2.add(top);
        }
        int x = q1.remove();
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
        return x;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}