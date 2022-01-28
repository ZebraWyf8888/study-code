package note.command;

/**
* @Author: WYF
* @Description: 命令模式
* @Create: 2020/3/30 17:44
* @Version: 1.0
*/
public class ProcessArray {
    /**
     * @Description: 对数组处理，什么处理方式不确定
     * @Param: [targer, command]
     * @Return: void
     * @Author: WYF
     * @Date: 2020/3/30 17:45
    */
    public void process(int[] targer,Command command){
        command.process(targer);
    }
}
