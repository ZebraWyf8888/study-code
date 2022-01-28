package macleetcode.day1004;

public class B {
    public static B b1 = new B();
    public static B b2 = new B();

    {
        System.out.println("构造代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        B b = new B();

        ListNode listNode = new ListNode();
    }
}
