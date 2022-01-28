package macleetcode.code1.studyqueue;

import java.sql.Time;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
* @Author: WYF
* @Description:
* @Create: 2020/3/27 15:04
* @Version: 1.0
*/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {

            try {
                System.out.println("插入");
                blockingQueue.put("1");
                System.out.println("插入");
                blockingQueue.put("2");
                System.out.println("插入");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.take();
                System.out.println("拿走了");
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.take();
                System.out.println("拿走了");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("拿走了");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
