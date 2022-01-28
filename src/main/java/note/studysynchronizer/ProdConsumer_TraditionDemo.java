package note.studysynchronizer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        SharaData sharaData = new SharaData();
         new Thread(() -> {
             sharaData.increment();
          },"t1").start();
         new Thread(() -> {
             sharaData.decrement();
          },"t2").start();
         new Thread(() -> {
             sharaData.increment();
          },"t3").start();
         new Thread(() -> {
             sharaData.decrement();
          },"t4").start();
    }


}

class SharaData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}