package macleetcode.day912;

class a extends Thread {

    public a() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("hello");
        a a = new a();
        a.setName("hello2");
        a.run();
    }
}
