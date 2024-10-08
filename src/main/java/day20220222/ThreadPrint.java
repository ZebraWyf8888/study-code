package day20220222;

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
 * 生产者、消费者
 *
 *
 * 就是常用的五种实现方案，多练习几次，手撕没问题。
 */
public class ThreadPrint {
    /**
     * 我们以第一题为例：三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串。
     *
     * 思路：使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，他们与 3 取模结果仍为本身，则执行打印逻辑。
     */
    static class PrintABCUsingLock {

        private int times; // 控制打印次数
        private int state;   // 当前状态值：保证三个线程之间交替打印
        private Lock lock = new ReentrantLock();

        public PrintABCUsingLock(int times) {
            this.times = times;
        }

        private void printLetter(String name, int targetNum) {
            for (int i = 0; i < times; ) {
                lock.lock();
                if (state % 3 == targetNum) {
                    state++;
                    i++;
                    System.out.print(name);
                }
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            PrintABCUsingLock loopThread = new PrintABCUsingLock(2);

            new Thread(() -> {
                loopThread.printLetter("B", 1);
            }, "B").start();

            new Thread(() -> {
                loopThread.printLetter("A", 0);
            }, "A").start();

            new Thread(() -> {
                loopThread.printLetter("C", 2);
            }, "C").start();
        }
    }
    static class PrintABCUsingWaitNotify {

        private int state;
        private int times;
        private static final Object LOCK = new Object();

        public PrintABCUsingWaitNotify(int times) {
            this.times = times;
        }

        public static void main(String[] args) {
            PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
            new Thread(() -> {
                printABC.printLetter("A", 0);
            }, "A").start();
            new Thread(() -> {
                printABC.printLetter("B", 1);
            }, "B").start();
            new Thread(() -> {
                printABC.printLetter("C", 2);
            }, "C").start();
        }

        private void printLetter(String name, int targetState) {
            for (int i = 0; i < times; i++) {
                synchronized (LOCK) {
                    while (state % 3 != targetState) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    state++;
                    System.out.print(name);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
