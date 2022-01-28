package note.adapter.twomethod;

import note.adapter.Adaptee;
import note.adapter.Target;

import java.util.ArrayList;
import java.util.List;

/**
* @Author: WYF
* @Description: 组合的方式，实现适配
* @Create: 2020/4/13 16:34
* @Version: 1.0
*/
public class ObjectAdapter implements Target {
    Adaptee a = new Adaptee();
    @Override
    public void request() {
        a.adapteeRequest();
        System.out.println("request的方法");
    }

}
