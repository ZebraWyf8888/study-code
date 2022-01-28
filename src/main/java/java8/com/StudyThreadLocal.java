package java8.com;

/**
* @Author: WYF
* @Description: 实现线程隔离的ThreadLocal
* @Create: 2020/4/5 16:59
* @Version: 1.0
*/
public class StudyThreadLocal {
    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM2 =new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public static void main(String[] args) {
         new Thread(() -> {
             addNum();
          },"t1").start();

         new Thread(() -> {
             addNum();
          },"t2").start();

         new Thread(() -> {
             addNum();
          },"t3").start();
    }

    public static void addNum(){
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM2.get();
            n += 1;
            THREAD_LOCAL_NUM2.set(n);
            System.out.println(Thread.currentThread().getName()+" "+THREAD_LOCAL_NUM2.get());
        }
    }
}
