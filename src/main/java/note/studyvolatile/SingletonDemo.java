package note.studyvolatile;

public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "号线程\t 把我实例化了 ");
    }

    /**
     * @Description: 双端锁机制
     * @Param: []
     * @Return: studyvolatile.SingletonDemo
     * @Author: WYF
     * @Date: 2020/3/13 22:02
     */
    public static SingletonDemo getInstance(){
        if (instance == null) {
            synchronized (SingletonDemo.class){
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
