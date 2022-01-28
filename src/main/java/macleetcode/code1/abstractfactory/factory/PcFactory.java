package macleetcode.code1.abstractfactory.factory;//package macleetcode.code1.abstractfactory.factory;
//
//
//import abstractfactory.product.CPU;
//import abstractfactory.product.PcCPU;
//import abstractfactory.product.PcRAM;
//import abstractfactory.product.RAM;
//
//public class PcFactory extends Factory {
//
//    @Override
//    public CPU createCPU() {
//        return new PcCPU();
//    }
//
//    @Override
//    public RAM createRAM() {
//        return new PcRAM();
//    }
//
//    @Override
//    public void createComputer(){
//        super.createComputer();
//        System.out.println("==构成pc");
//    }
//}
