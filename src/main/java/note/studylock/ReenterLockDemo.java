package note.studylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @Author: WYF
* @Description: 可重入锁 synchronized
* @Create: 2020/3/22 15:19
* @Version: 1.0
*/
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendEmail();
        },"t1").start();
        new Thread(()->{
            phone.sendEMS();
        },"t1").start();
    }
}
class Phone implements Runnable{
    public synchronized void sendEmail(){
        System.out.println("sendEmail");
        sendEMS();
    }
    public synchronized void sendEMS(){
        System.out.println("sendEms");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println("get");
            set();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println("set");
        }finally {
            lock.unlock();
        }
    }
}