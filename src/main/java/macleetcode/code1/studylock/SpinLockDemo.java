package macleetcode.code1.studylock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
* @Author: WYF
* @Description: 自旋锁
* @Create: 2020/3/22 16:12
* @Version: 1.0
*/
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference =new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        while(!atomicReference.compareAndSet(null, thread)){

        }
    }
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null );
        System.out.println(Thread.currentThread().getName()+"\t come out");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo =new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myLock();
            //线程T2进入while循环
            spinLockDemo.myUnLock();
        },"t2").start();
    }
}
