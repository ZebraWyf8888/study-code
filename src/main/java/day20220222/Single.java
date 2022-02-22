package day20220222;

public class Single {

    volatile private static  Single ins ;

    private Single() {
    }

    public static Object getInstance(){
        if (ins == null) {
            synchronized (Single.class){
                if (ins == null) {
                    ins = new Single();
                }
            }
        }
        return ins;
    }
}
