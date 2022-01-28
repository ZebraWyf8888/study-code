package note.decorator;

/**
* @Author: WYF
* @Description: 具体的角色1:原有基础上，对请求行解析
* @Create: 2020/4/26 14:31
* @Version: 1.0
*/
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }
    /**
     * @Description: 自己的方法
     * @Param: []
     * @Return: void
     * @Author: WYF
     * @Date: 2020/4/26 14:28
    */
    private void decorateMethod2(){
        System.out.println("基础功能上叠加，对请求行解析");
    }
    //重写父类的方法
    @Override
    public  void analy(){
        //原本的
        super.analy();
        //调用自己独有功能
        this.decorateMethod2();
    }
}
