package java8.com.nk;

public class Test3 {
    public static void main(String args[]){
        final byte b1 = 1;
        final byte b2 = 2;
        byte b3 = 3;

        byte b4 = b1 + b2;//只有b1 b2 都是常量时候，才能编译运行成功
        //即使是一个byte+一个常量也不行
        //byte b6 = b1 + b3;//编译不通过

        byte b5;//定义了不用，不需要赋值，但是怎么做就是浪费内存 没有用
        System.out.println(b4);
    }
}