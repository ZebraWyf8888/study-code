package macleetcode.code1.studyvolatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyClass {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addNum(){
        number++;
    }

    AtomicInteger atomicnum = new AtomicInteger();

    public void addatomicnum(){
        atomicnum.getAndIncrement();
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        seekOkByVolatile();
//        MyClass myClass = new MyClass();
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    myClass.addNum();
//                    myClass.addatomicnum();
//                }
//            },String.valueOf(i)).start();
//        }
//
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }
//
//        System.out.println(Thread.currentThread().getName()+"\t "+myClass.number);
//        System.out.println(Thread.currentThread().getName()+"\t "+myClass.atomicnum);
    }

    //保证可见性代码
    private static void seekOkByVolatile() {
        MyClass myClass = new MyClass();
        //线程1 改
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myClass.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated" + myClass.number);
        }, "AAA").start();

        //线程2 判断，循环
        while (myClass.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "/t mission is over");
    }
}
