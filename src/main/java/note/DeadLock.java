package note;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "lockB";
        new Thread(
                new HoldThread(lockA, lockB)
                , "aaa").start();

        new Thread(
                new HoldThread(lockB, lockA)
                , "bbb").start();
    }
}

class HoldThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "我有了" + lockA + "我来锁B");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println("ok");
            }
        }
    }
}