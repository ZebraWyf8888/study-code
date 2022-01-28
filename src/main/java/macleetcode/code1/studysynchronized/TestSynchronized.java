package macleetcode.code1.studysynchronized;

/**
* @Author: WYF
* @Description:
 * 通过一个时刻，只有一个线程可以访问资源（TestSynchronized）里加了synchronized的方法
 * 他的非synchronized，还是可以被访问
* @Create: 2020/3/31 15:09
* @Version: 1.0
*/
public class TestSynchronized {
    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void test3() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread((Runnable)() -> {

                myt2.test2();

        }, "test2");

        Thread test3 = new Thread((Runnable)() -> {

                myt2.test3();

        }, "test3");
        test1.start();
        test2.start();
        test3.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }

}