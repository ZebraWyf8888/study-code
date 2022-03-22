package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by StoneGeek on 2018/5/19.
 * 博客地址：http://www.cnblogs.com/sxkgeek
 * 当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。
 * 当线程执行notify()/notifyAll()方法时，会唤醒一个处于等待状态该对象锁的线程，然后继续往下执行，直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁
 * 个人认为synachronized（）{}执行完后会释放锁
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag) {
                    System.out.println(Thread.currentThread().getName()
                            + " flag is true. wait@ "
                            + new SimpleDateFormat("HH:mm:ss")
                            .format(new Date()));
                    try {
                        lock.wait();
                        System.out.println("此处继续执行"+Thread.currentThread().getName());
//                        flag=true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread().getName()
                        + " flag is false. running@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"执行结束");
            }
        }
    }

    // wait()会立刻释放synchronized（obj）中的obj锁，以便其他线程可以执行obj.notify()
    // 但是notify()不会立刻立刻释放sycronized（obj）中的obj锁，必须要等notify()所在线程执行完synchronized（obj）块中的所有代码才会释放这把锁.
    // yield(),sleep()不会释放锁
    static class Notify implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread().getName()
                        + " hold lock. notify @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {

                System.out.println(e);
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()
                        + " hold lock again. sleep@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"执行结束");
            }
        }
    }
}