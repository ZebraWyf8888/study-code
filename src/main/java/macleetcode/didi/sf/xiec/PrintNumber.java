package macleetcode.didi.sf.xiec;

import java.util.Deque;
import java.util.LinkedList;

//顺序打印线程
public class PrintNumber extends Thread {
    private static int cnt = 0;
    private int id;  // 线程编号

    public PrintNumber(int id) {
        this.id = id;
    }
//    private static Lock lock = new ReentrantLock();
//    private static Condition condition = lock.newCondition();
//    private int id;

    @Override
    public void run() {
        while (cnt <= 100) {
            while (cnt % 2 == id) {
                synchronized (PrintNumber.class) {
                    cnt++;
                    System.out.println("thread_" + id + " num:" + cnt);
                }
            }
        }
    }
//    @Override
//    public void run() {
//        while (cnt <= 100) {
//            synchronized (PrintNumber.class) {
//                cnt++;
//                System.out.println("thread_" + id + " num:" + cnt);
//                PrintNumber.class.notify();
//                try {
//                    PrintNumber.class.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Thread thread0 = new PrintNumber(0);
        Thread thread1 = new PrintNumber(1);
        thread0.start();
        thread1.start();
    }
}

//最小栈
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
