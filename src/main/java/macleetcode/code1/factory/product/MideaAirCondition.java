package macleetcode.code1.factory.product;

public class MideaAirCondition implements Product {
    @Override
    public void draw() {
        System.out.println("使用MideaAirCondition:"+this.getClass());
    }
}
