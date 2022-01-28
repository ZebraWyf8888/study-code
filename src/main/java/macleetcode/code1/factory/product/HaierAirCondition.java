package macleetcode.code1.factory.product;

public class HaierAirCondition implements Product {

    @Override
    public void draw() {
        System.out.println("使用HaierAirCondition:"+this.getClass());
    }
}

