package note.abstractfactory.factory;

import note.abstractfactory.product.CPU;
import note.abstractfactory.product.RAM;

/**
 * @Author: WYF
 * @Description: 工厂接口
 * @Create: 2020-04-06 16:03
 * @Version: 1.0
 */
public abstract class Factory {
    /**
     * 建立CPU
     *
     * @Param void
     * @return CPU
     */
    abstract CPU createCPU();
    /**
     * 建立RAM
     *
     * @Param void
     * @return RAM
     */
    abstract RAM createRAM();

    public void createComputer(){
        CPU c = this.createCPU();
        RAM r = this.createRAM();
        c.draw();
        r.draw();
    }
}
