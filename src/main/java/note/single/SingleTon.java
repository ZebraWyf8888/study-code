package note.single;

/**
* @Author: WYF
* @Description: 双端锁+volatile实现懒汉的单例
* @Create: 2020/3/30 15:25
* @Version: 1.0
*/
public class SingleTon {
    volatile private static SingleTon singleTon = null;
    private SingleTon(){
        System.out.println("实例化1次");
    }

    public static SingleTon getInstance(){
        /**
         *解释：当A与B同时调用getSingleton时，判断第一个if都为空，这时A拿到锁，进行第二层if判断，条件成立new了一个对象；

         B在外层等待，A创建完成，释放锁，B拿到锁，进行第二层if判断，条件不成立，结束释放锁。C调用getSingleton时第一层判断不成立，直接拿到singleton对象返回，避免进入锁，减少性能开销。
         ————————————————
         版权声明：本文为CSDN博主「小韩同志」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
         原文链接：https://blog.csdn.net/jlnu0812407/article/details/102836187
        */
        if (singleTon == null){
            synchronized (SingleTon.class){
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                SingleTon.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
