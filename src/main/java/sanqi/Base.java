package sanqi;

public class Base {
   String baseName = "base";

    public Base(){
        callName();
    }

    private void callName() {
        System.out.println(baseName);
    }
    static class Sub extends Base{
        String baseName = "sub";

        private void callName() {
            System.out.println(baseName);
        }

    }

    public static void main(String[] args) {
        Base b = new Sub();
        int i = 2147483647;
        int j = 2<<1;
        int int1 = i+j;
        long long2 = i+j;
        System.out.println(int1);
        System.out.println(long2);
    }
}
