package macleetcode.code1.decorator.decoratortest;

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
    */
    private void lose(){
        System.out.println("基础功能上叠加，遗失功能");
    }
    @Override
    public void borrowBook() {
        super.borrowBook();
        lose();
    }

    @Override
    public void returnBook() {
        lose();
        super.returnBook();
    }
}
