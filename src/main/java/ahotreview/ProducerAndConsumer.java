package ahotreview;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author X09380
 */
public class ProducerAndConsumer {

    private static final int MAX_LEN = 10;
    private static Queue<Integer> queue = new LinkedList();
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer();
        Thread threadP = new Thread(p);
        Thread threadC = new Thread(c);
        threadP.start();
        threadC.start();
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            doConsumer();
        }

        private void doConsumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()){
                        System.out.println("当前队列为空");
                        condition1.await();
                    }
                    queue.poll();
                    condition2.signal();
                    System.out.println("get 1");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            doProducer();
        }

        private void doProducer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_LEN){
                        System.out.println("man");
                        condition2.await();
                    }
                    queue.add(1);
                    condition1.signal();
                    System.out.println("shengc");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}


