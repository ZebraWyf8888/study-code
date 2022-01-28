package macleetcode.code1;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
* @Author: WYF
* @Description: 实现call线程
* @Create: 2020/3/30 20:16
* @Version: 1.0
*/
public class NewThreadCall {
    public static void main(String[] args) {
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(
//                new Callable<Integer>() {
//                    @Override
//                    public Integer call() throws Exception {
//                        int i ;
//                        for (i = 0; i < 100; i++) {
//                            System.out.println(Thread.currentThread().getName() + "\t"+i);
//                        }
//                        return i;
//                    }
//                }
                (Callable<Integer>) ()->{
                    int i ;
                        for (i = 0; i < 100; i++) {
                            System.out.println(Thread.currentThread().getName() + "\t"+i);
                        }
                        return i;
                }
        );

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"\t "+i);
            if (i == 20) {
                new Thread(integerFutureTask,"有返回值的线程").start();
            }
        }
        try {
            System.out.println(integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
