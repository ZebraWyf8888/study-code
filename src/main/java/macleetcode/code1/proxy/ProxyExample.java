package macleetcode.code1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample{
    static interface Car{
        void running();
    }
    static class Bus implements Car{
        @Override
        public void running() {
            System.out.println("The bus is running");
        }
    }
    static class Taxi implements Car{
        @Override
        public void running() {
            System.out.println("The Taxi is running");
        }
    }

    static class JDKProxy implements InvocationHandler{
        /**
         * @Description: 代理对象
        */
        private Object target;

        /**
         * 取得代理对象（此时的代理对象已经委托完毕）
        */
        public Object getInstance(Object target) {
            this.target = target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        /**
         * @Description: 执行代理的方法
         * @Param: proxy：代理对象
         * @Param: method：代理方法
         * @Param: args：参数
         * @Return: java.lang.Object
         * @Author: WYF
         * @Date: 2020/4/7 11:20
        */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理之前的业务");
            Object result  = method.invoke(target,args);
            System.out.println("动态代理之后的业务");
            return result;
        }
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Car instance = (Car) jdkProxy.getInstance(new Taxi());
        instance.running();
    }
}