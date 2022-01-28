package macleetcode.day804;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author wangyifan
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Future> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Future<String> future;
            if (i == 0 || i == 1) {
                future = executorService.submit(new SlowTask());
            } else {
                future = executorService.submit(new FastTask());
            }
            list.add(future);
        }
        for (int i = 0; i < 4; i++) {
            Future<String> future = list.get(i);

            String s = null;

            /**
             * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=287
             */
            try {
                s = future.get(1, TimeUnit.SECONDS);
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            // s = future.get();


        }
        executorService.shutdown();
    }

    static class SlowTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "慢任务";
        }
    }

    static class FastTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "快任务";
        }
    }
}
