package macleetcode.code1.command.commandtest;

/**
* @Author: WYF
* @Description: 菜单项
* @Create: 2020/5/30 23:10
* @Version: 1.0
*/
public class MenuItem {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click(){
        command.excute();
    }
}
