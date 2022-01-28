package note.factory;

import note.factory.factory.*;

/**
* @Author: WYF
* @Description: 抽象工厂模式的测试
* @Create: 2020/4/6 16:13
* @Version: 1.0
*/
public class TestFactory {
    public static void main(String[] args) {
        Factory factory1 = new HaierAirFactory();
        Factory factory2 = new MideaFactory();
        factory1.createProduct().draw();
        factory2.createProduct().draw();
    }
}
