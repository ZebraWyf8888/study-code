package macleetcode.code1.single;

/**
* @Author: WYF
* @Description:
 * 了解JVM的类加载机制的朋友应该对这部分比较清楚。static类型的属性会在类被加载之后被初始化，当一个Java类第一次被真正使用到的时候静态资源会被初始化、Java类的加载和初始化过程都是线程安全的（因为虚拟机在加载枚举的类的时候，会使用ClassLoader的loadClass方法，而这个方法使用同步代码块保证了线程安全）。所以，创建一个enum类型是线程安全的。

也就是说，我们定义的一个枚举，在第一次被真正用到的时候，会被虚拟机加载并初始化，而这个初始化过程是线程安全的。而我们知道，解决单例的并发问题，主要解决的就是初始化过程中的线程安全问题。

所以，由于枚举的以上特性，枚举实现的单例是天生线程安全的。
————————————————
版权声明：本文为CSDN博主「CrankZ」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/CrankZ/article/details/84954388
* @Create: 2020/3/30 23:00
* @Version: 1.0
*/
public enum EasySingleton{
    INSTANCE;
}
/**
 * 更重要的是枚举不会存在反射问题（其他版本可以通过破坏构造器的私有化），jdk对枚举是序列化实现了特殊的规定
*/