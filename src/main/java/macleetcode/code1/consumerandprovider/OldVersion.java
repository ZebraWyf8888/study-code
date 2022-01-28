package macleetcode.code1.consumerandprovider;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @Author: WYF
* @Description:
* @Create: 2020/3/27 16:01
* @Version: 1.0
*/
public class  OldVersion {
    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i = 0; i < 10 ; i++) {
             new Thread(() -> {
                 try {
                     resource.increment();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             },"p A").start();
        }

        for (int i = 0; i < 5 ; i++) {
             new Thread(() -> {
                 try {
                     resource.increment();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             },"p B").start();
        }

        for (int i = 0; i < 10 ; i++) {
             new Thread(() -> {
                 try {
                     resource.decrement();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             },"c A").start();
        }
        for (int i = 0; i < 5 ; i++) {
             new Thread(() -> {
                 try {
                     resource.decrement();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             },"c B").start();
        }
    }

}
/**
* @Author: WYF
* @Description: 资源
* @Create: 2020/3/27 16:02
* @Version: 1.0
*/
class Resource{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception {
        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                //等待不能生产
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                //等待不能消费
                condition.await();
            }
            //2.消费
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
