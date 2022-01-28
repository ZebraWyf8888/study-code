package macleetcode.code1.abstractfactory.product;

public class PcCPU implements CPU {
    @Override
    public void draw() {
        System.out.print("Pc的CPU功能+");
    }
}
