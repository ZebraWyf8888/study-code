package note;

import java.util.concurrent.*;

/**
* @Author: WYF
* @Description:
* @Create: 2020/3/27 16:48
* @Version: 1.0
*/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 0; i < 10; i++) {
                final Integer x = i;
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t "+x);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}
