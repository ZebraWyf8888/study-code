package note.abstractfactory;

import note.abstractfactory.factory.Factory;
import note.abstractfactory.factory.MacFactory;
import note.abstractfactory.factory.PcFactory;

/**
* @Author: WYF
* @Description: 抽象工厂模式的测试
* @Create: 2020/4/6 16:13
* @Version: 1.0
*/
public class TestFactory {
    public static void main(String[] args) {
        Factory pcFactory = new PcFactory();
        pcFactory.createComputer();
        Factory macFactory = new MacFactory();
        macFactory.createComputer();
    }
}
