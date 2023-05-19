package ahot;

import java.util.concurrent.TimeUnit;
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
                    System.out.println(name);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            PrintABCUsingLock loopThread = new PrintABCUsingLock(1000);

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




    static public class PrintABCUsingLockCondition {

        private int times;
        private int state;
        private static Lock lock = new ReentrantLock();
        private static Condition c1 = lock.newCondition();
        private static Condition c2 = lock.newCondition();
        private static Condition c3 = lock.newCondition();

        public PrintABCUsingLockCondition(int times) {
            this.times = times;
        }

        public static void main(String[] args) {
            PrintABCUsingLockCondition print = new PrintABCUsingLockCondition(10);
            new Thread(() -> {
                print.printLetter("A", 0, c1, c2);
            }, "A").start();
            new Thread(() -> {
                print.printLetter("B", 1, c2, c3);
            }, "B").start();
            new Thread(() -> {
                print.printLetter("C", 2, c3, c1);
            }, "C").start();
        }

        private void printLetter(String name, int targetState, Condition current, Condition next) {
            for (int i = 0; i < times; ) {
                lock.lock();
                try {
                    while (state % 3 != targetState) {
                        current.await();
                    }
                    state++;
                    i++;
                    System.out.print(name);
                    next.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static public class PrintABCUsingLockCondition2 {
        private int state;
        private int time;
        private static Lock lock = new ReentrantLock();
        private static Condition c1 = lock.newCondition();
        private static Condition c2 = lock.newCondition();
        private static Condition c3 = lock.newCondition();

        public PrintABCUsingLockCondition2(int t){
            this.time = t;
        }

        public static void main(String[] args) {
            PrintABCUsingLockCondition2 print = new PrintABCUsingLockCondition2(10);

            new Thread(()->{
                print.printNumber("A1",c1,c2,0);
            }).start();

            new Thread(()->{
                print.printNumber("B2",c2,c3,1);
            }).start();

            new Thread(()->{
                print.printNumber("C3",c3,c1,2);
            }).start();
        }

        private void printNumber(String s, Condition c1, Condition c2, int tar) {
            for (int j = 0; j < time; ) {
                lock.lock();
                try {
                    while (state % 3 != tar){
                        c1.await();
                    }
                    state++;
                    j++;
                    System.out.println(s);
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

        }
    }
}
