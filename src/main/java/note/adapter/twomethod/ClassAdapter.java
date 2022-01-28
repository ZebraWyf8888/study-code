package note.adapter.twomethod;

import note.adapter.Adaptee;
import note.adapter.Target;

/**
* @Author: WYF
* @Description: 我们的需求就是要Target的接口实现Adaptee的方法
 * 第一种是类适配模式，从类继承的角度，实现适配器
* @Create: 2020/4/13 15:39
* @Version: 1.0
*/
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("request本身的方法");
        super.adapteeRequest();
    }
}
