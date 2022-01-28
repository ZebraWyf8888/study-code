package macleetcode.code1.studylock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @Author: WYF
* @Description: lock与synchronized 优势第五点，利用condition实现准确唤醒
* @Create: 2020/3/27 15:31
* @Version: 1.0
*/
public class GoodAtLock {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
         new Thread(() -> {
             for (int i = 0; i < 10; i++) {
                 shareResource.print5();
             }
          },"A").start();

         new Thread(() -> {
             for (int i = 0; i < 10; i++) {
                 shareResource.print10();
             }
          },"B").start();

         new Thread(() -> {
             for (int i = 0; i < 10; i++) {
                 shareResource.print15();
             }
          },"C").start();
    }

}

/**
* @Author: WYF
* @Description: 资源类
* @Create: 2020/3/27 15:39
* @Version: 1.0
*/
class ShareResource{
    volatile private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while (number != 1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"  \t "+i);
            }
            number = 2;
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            while (number != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"  \t "+i);
            }
            number = 3;
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            while (number != 3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"  \t "+i);
            }
            number = 1;
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}