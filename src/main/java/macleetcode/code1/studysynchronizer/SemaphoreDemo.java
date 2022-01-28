package macleetcode.code1.studysynchronizer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
* @Author: WYF
* @Description: 第三个同步器
* @Create: 2020/3/22 23:35
* @Version: 1.0
*/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for(int i = 1; i <= 6; i++){
            final int tempInt = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到资源，开始运用资源");
                    try {
                        TimeUnit.SECONDS.sleep(tempInt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"运用资源完毕，释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
