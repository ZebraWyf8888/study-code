package macleetcode.callback;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/jzg5845201314/article/details/99644439
 * @author wangyifan
 */
public class NettyTest1 {
    static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void doStm(final ICallBack callBack) {
        Thread t = new Thread(
                () -> {
                    System.out.println("子线程：" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("a1","这是我返回的字符串");
                    callBack.callBack(map);
                }

        );
        es.execute(t);
        es.shutdown();
    }

    public static void main(String[] args) {
        doStm(
                (param)->{
                    System.out.println("单个线程也已经处理完毕了，返回参数a1=" + param.get("a1"));
                }
        );
        System.out.println("主线任务已经执行完了:"+Thread.currentThread().getId());
    }
}
