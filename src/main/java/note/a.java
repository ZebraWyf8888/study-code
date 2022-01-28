package note;

public class a{
    public static void main(String[] args) {
       /* String str1 = "hello";//字面量 只会在常量池中创建对象
        String str2 = str1.intern();
        System.out.println(str1==str2);//true
        String str3 = new String("world");//new 关键字只会在堆中创建对象
        String str4 = str3.intern();
        System.out.println(str3 == str4);//false
        String str5 = str1 + str2;//变量拼接的字符串，会在常量池中和堆中都创建对象
        String str6 = str5.intern();//这里由于池中已经有对象了，直接返回的是对象本身，也就是堆中的对象
        System.out.println(str5 == str6);//true*/
        String str1 = "hello";
        String str2 = "helloworld";
        String str3 = str1+"world";//编译器不能确定为常量(会在堆区创建一个String对象)
        String str4 = "hello"+"world";//编译器确定为常量，直接到常量池中引用
        System.out.println(str2==str3);//fasle
        System.out.println(str2==str4);//true
        System.out.println(str3==str4);//fasle

        Thread thread = new Thread(() -> {
            System.out.println("aaa");
        }, "t");
        thread.start();
        thread.start();
    }
}
