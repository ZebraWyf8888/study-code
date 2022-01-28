package macleetcode.code1.single;

/**
* @Author: WYF
* @Description: SingleT的最佳，用静态内部类实现
 * 在内部类被加载/初始化的时候创建对象，
 * 静态内部类不不会随着外部类的初始化而初始化
* @Create: 2020/3/30 15:50
* @Version: 1.0
*/
public class SingleTon3 {
    /**
     * 第一步，毫无疑问，构造器私有
    */
     private SingleTon3(){};
     /**
      * 2.静态内部类
     */
     private static class SingletonHolder{
         private static final SingleTon3 INSTANCE = new SingleTon3();
     }

     /**
      * @Description: d
      * @Param:
      * @Return:
      * @Author: WYF
      * @Date: 2020/3/30 15:54
     */
     public static final SingleTon3 getInstance(){
         return SingletonHolder.INSTANCE;
     }

}
