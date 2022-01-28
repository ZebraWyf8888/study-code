package macleetcode.code1.leetcode;

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1 ;
    Stack<Integer> s2 ;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        Integer pop = s2.pop();
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        Integer pop = s2.peek();
        return pop;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty()&&s2.empty();
    }

    public static void main(String[] args) {

         // Your MyQueue object will be instantiated and called as such:
          MyQueue obj = new MyQueue();
         obj.push(1);
         int param_2 = obj.pop();
         int param_3 = obj.peek();
         boolean param_4 = obj.empty();
    }
}