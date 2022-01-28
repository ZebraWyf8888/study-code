package macleetcode.code1.single;

public class Test {
    public static void main(String[] args) {
        SingleTon2 s = SingleTon2.INSTANCE;
        System.out.println(s);
        int l = 2>>67;
        System.out.println(l);
    }
}
