package note.studysynchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
* @Author: WYF
* @Description: 
* @Create: 2020/3/22 22:59
* @Version: 1.0
*/
public class CyclicBarrieDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,() ->
        {
//            Thread thread = Thread.currentThread();
//            thread.setName("裁判");
            System.out.println(Thread.currentThread().getName()+"我们开跑吧");
        });
        for(int i = 0; i < 10; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 我到了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t 我跑了");
            },String.valueOf(i)).start();
        }
    }
}
