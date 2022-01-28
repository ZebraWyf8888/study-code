package note.abstractfactory.product;

public class PcRAM implements RAM {
    @Override
    public void draw() {
        System.out.print("Pc的RAM功能");
    }
}

