package ahot;//synchronized版本
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProducerAndConsumer1 {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        queue.notify();
                        System.out.println("当前队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("当前队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumer1 pc = new ProducerAndConsumer1();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}

//lock版实现，使用了condition做线程之间的同步。

/**
 * version 1 doesn't use synchronized to improve performance
 */
class ProducerAndConsumer2 {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    condition.signal();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("当前队列为空");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    condition.signal();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumer2 pc = new ProducerAndConsumer2();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}

//跟2一样，只是实现了精确唤醒（notify）
class ProducerAndConsumer22 {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    condition2.signal();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("当前队列为空");
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    condition1.signal();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumer22 pc = new ProducerAndConsumer22();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}

//BlockingQueue版实现


class ProducerAndConsumer3 {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(new Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(new Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumer3 pc = new ProducerAndConsumer3();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}
