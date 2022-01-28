package note.decorator;

public class TestDecoratorDemo {
    public static void main(String[] args) {
        //核心组件
        Component concreteComponent = new ConcreteComponent();
        //第一次给他一个装饰，不修改源代码，只进行迭代
        Component concreteDecorator1 = new ConcreteDecorator1(concreteComponent);

        //第二次迭代
        Component concreteDecorator2 = new ConcreteDecorator2(concreteDecorator1);

        concreteDecorator2.analy();
    }
}
