package note.decorator.decoratortest;

/**
* @Author: WYF
* @Description: 具体的角色1:原有基础上，对请求头解析
* @Create: 2020/4/26 14:31
* @Version: 1.0
*/
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    /**
     * @Description: 冻结方法
     * @Param: []
     * @Return: void
     * @Author: WYF
    */
    private void freeze(){
        System.out.println("基础功能上叠加，冻结功能");
    }

    @Override
    public void borrowBook() {
        super.borrowBook();
        freeze();
    }

    @Override
    public void returnBook() {
        freeze();
        super.returnBook();
    }
}
