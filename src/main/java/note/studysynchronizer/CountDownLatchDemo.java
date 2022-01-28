package note.studysynchronizer;

import java.util.concurrent.CountDownLatch;

/**
* @Author: WYF
* @Description: 学习第一个同步器，CountDownLatch
* @Create: 2020/3/22 17:51
* @Version: 1.0
*/
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i < 7; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 国被灭");
                countDownLatch.countDown();
            },CountryEnum.foreach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 六国灭亡 秦国统一了 ");
    }
}
