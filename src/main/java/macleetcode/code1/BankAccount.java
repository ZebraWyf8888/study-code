package macleetcode.code1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    /**
     * 这里要求定义读写锁，以前的一般锁无法实现读写分离，读时候共享，写时独占+原子
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    volatile private long balance;
    /**
     * flag 标志 是否可以对该账户操作
     */
    private volatile boolean flag = true;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    static void transferFrom(BankAccount source, BankAccount dest, long amount) {
        if (source.flag && dest.flag) {
            /**
             *修改标志位
             */
            source.flag = false;
            dest.flag = false;
            /**
             *加锁
             */
            source.rwLock.writeLock().lock();
            dest.rwLock.writeLock().lock();
            try {
                source.balance -= amount;
                dest.balance += amount;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                source.rwLock.writeLock().unlock();
                dest.rwLock.writeLock().unlock();
                /**
                 *修改标志位
                 */
                source.flag = true;
                dest.flag = true;
            }
        }
    }

    public long balance() {
        rwLock.readLock().lock();
        try {
            return balance;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
        return balance;
    }
}
