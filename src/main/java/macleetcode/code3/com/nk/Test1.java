package macleetcode.code3.com.nk;

public class Test1{
    private float f = 1.0f;
    int m = 12;


    static int n = 1;
    public static void main (String args[])
    {
        int a = ~9;
        System.out.println(a);
//        int a = 5;
//        int c = (++a)+(++a);
//        System.out.println(c);
//        Test1 t = new Test1();
//        System.out.println(t.f);
        //System.out.println(this.n);//不行的
        //这里t.f是没问题的
        //t.main(new String[]{"SSS"});//重复调用main出错
    }
}