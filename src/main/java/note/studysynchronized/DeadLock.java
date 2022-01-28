package note.studysynchronized;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: WYF
 * @Description: 死锁
 * @Create: 2020/3/31 15:14
 * @Version: 1.0
 */
public class DeadLock {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Resource resource2 = new Resource();
        new Thread(() -> {
            resource.lock1want2();
        }, "t1").start();

        new Thread(() -> {
            resource2.lock2want1();
        }, "t2").start();
        String[] s = {"aa","bb","cc"};
        Arrays.asList(s);
    }

}


class Resource {
    /**
     *踩过的一个坑，如果是String，他在常量池，即使new两个Resource，在不同对象中，他依然是同一个引用
     * 所以会产生死锁，如果改为大于127的integer ，不会死锁
     */
    String string1 = "AAA";
    String string2 = "BBB";

    public void lock1want2() {

        synchronized (string1) {
            System.out.println(Thread.currentThread().getName() + " \t 我有了1我试试看能不能要二");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (string2) {
                System.out.println("拿到了");
            }
        }
    }

    public void lock2want1() {
        synchronized (string2) {
            System.out.println(Thread.currentThread().getName() + " \t 我有了2我试试看能不能要1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (string1) {
                System.out.println("拿到了");
            }
        }
    }

}