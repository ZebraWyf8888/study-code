package macleetcode.code1.decorator.decoratortest;

/**
* @Author: WYF
* @Description: 装饰者角色，包含指向抽象部件的指针
* @Create: 2020/4/26 14:24
* @Version: 1.0
*/
public abstract class Decorator extends Component {
    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void borrowBook() {
        this.component.borrowBook();
    }

    @Override
    public void returnBook() {
        this.component.returnBook();
    }
}
