package note.abstractfactory.factory;


import note.abstractfactory.product.CPU;
import note.abstractfactory.product.PcCPU;
import note.abstractfactory.product.PcRAM;
import note.abstractfactory.product.RAM;

public class PcFactory extends Factory {

    @Override
    public CPU createCPU() {
        return new PcCPU();
    }

    @Override
    public RAM createRAM() {
        return new PcRAM();
    }

    @Override
    public void createComputer(){
        super.createComputer();
        System.out.println("==构成pc");
    }
}
