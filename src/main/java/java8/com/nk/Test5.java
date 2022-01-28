package java8.com.nk;

import java.util.List;

class A {

}

class B {

}

class D extends B {

}

public class Test5 {

    public static void main(String[] args) {
        List<A> a = null;
        List list = null;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b = null;
//        a = b;      //B错，点之间不能相互赋值
//        List<?> qm = null;
//        List<Object> o = null;
//        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
//        List<D> d = null;
//        List<? extends B> downB;
//        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
//        List<? extends A> downA;
//        a = downA;  //E错，范围不能赋值给点
//        a = o;      //F错，List<Object>只是一个点
//        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
    }
}
