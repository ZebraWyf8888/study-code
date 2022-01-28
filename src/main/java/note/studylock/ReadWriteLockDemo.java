package note.studylock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @Author: WYF
* @Description: 读写锁
* @Create: 2020/3/22 16:28
* @Version: 1.0
*/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for(int i = 0; i < 5; i++){
            /**
             * lambda 表达式要求是常量，将i转为常量
            */
            final int tempInt = i;
            new Thread(() -> {
                myResource.put(tempInt+"", tempInt+"");
            },String.valueOf(i)).start();
        }

        for(int i = 0; i < 5; i++){
            final int tempInt = i;
            new Thread(() -> {
                myResource.get(tempInt+"");
            },String.valueOf(i)).start();
        }

    }
}
/**
* @Author: WYF
* @Description: 缓存资源的读写锁操作，读共享，写（独占+原子）
* @Create: 2020/3/22 16:32
* @Version: 1.0
*/
class MyResource{
    /**
     * 缓存的东西非常快,必须volatile
    */
    private volatile Map<String,Object> map = new HashMap();
    /**
     * 这里要求定义读写锁，以前的一般锁无法实现读写分离，读时候共享，写时独占+原子
    */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * @Description: 写入的方法
     * @Param: [key, value]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/22 17:06
    */
    public void put(String key ,Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正写入："+key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }
    }

    /**
     * @Description: 读取的方法
     * @Param: [key]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/22 17:06
     */
    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正读取："+key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }
    }

    /**
     * @Description: 模拟清除缓存
     * @Param: []
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/22 17:12
    */
    public void clearMap(){
        map.clear();
    }
}