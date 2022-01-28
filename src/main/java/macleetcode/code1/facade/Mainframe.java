package macleetcode.code1.facade;

/**
* @Author: WYF
* @Description: 电脑主机
* @Create: 2020/5/30 21:39
* @Version: 1.0
*/
public class Mainframe {
    private HardDisk hardDisk = new HardDisk();
    private Memory memory = new Memory();
    private OS os = new OS();
    public void on(){
        hardDisk.read();
        memory.check();
        os.load();
    }
}
