package macleetcode.code1.studylock;

/**
* @Author: WYF
* @Description: 可重入锁 ReenterLock
* @Create: 2020/3/22 15:19
* @Version: 1.0
*/
public class ReenterLockDemo2 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(phone,"t1").start();
        new Thread(phone,"t2").start();
    }
}

