package ahotreview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替线程打印
 * https://www.cnblogs.com/lazyegg/p/13900847.html
 * 最喜欢问的多个线程顺序打印问题，我遇到的是机试，直接写出运行。同类型的题目有很多，比如
 *
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * 两个线程交替打印 0~100 的奇偶数
 * 通过 N 个线程顺序循环打印从 0 至 100
 * 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
 * 用两个线程，一个输出字母，一个输出数字，交替输出 1A2B3C4D...26Z
 */
public class PrintABCUsingLockCondition {
    private int state;
    private int time;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 =  lock.newCondition();
    private static Condition c2 =  lock.newCondition();
    private static Condition c3 =  lock.newCondition();

    public PrintABCUsingLockCondition(int time) {
        this.time = time;
    }

    private void printfNumber(String s , Condition c1, Condition c2, int tar){
        for (int i = 0; i < time; i++) {
            lock.lock();
            try {
                while (state%3 != tar){
                    c1.await();
                }
                System.out.println(s);
                state++;
                i++;
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition print = new PrintABCUsingLockCondition(10);

        new Thread(()->{
            print.printfNumber("A1",c1,c2,0);
        }).start();

        new Thread(()->{
            print.printfNumber("B2",c2,c3,1);
        }).start();

        new Thread(()->{
            print.printfNumber("C3",c3,c1,2);
        }).start();
    }
}
