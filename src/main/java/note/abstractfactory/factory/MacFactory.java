package note.abstractfactory.factory;

import note.abstractfactory.product.CPU;
import note.abstractfactory.product.MacCPU;
import note.abstractfactory.product.MacRAM;
import note.abstractfactory.product.RAM;

public class MacFactory extends Factory {
    @Override
    public CPU createCPU() {
        return new MacCPU();
    }

    @Override
    public RAM createRAM() {
        return new MacRAM();
    }

    @Override
    public void createComputer(){
        super.createComputer();
        System.out.println("==构成Mac-Book");
    }
}
