package macleetcode.code1.command.commandtest;

public class CommandTest {
    public static void main(String[] args) {
        /**
         * 给每个菜单项添加一个命令
        */
        MenuItem menuItem1 = new MenuItem();
        menuItem1.setCommand(new CreateCommand());
        MenuItem menuItem2 = new MenuItem();
        menuItem2.setCommand(new OpenCommand());
        MenuItem menuItem3 = new MenuItem();
        menuItem3.setCommand(new EditCommand());
        /**
         * 把菜单项放入菜单栏
        */
        Menu menu = new Menu();
        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);
        /**
         * 对于使用者来说，实现了无差别调用，调用者只需要点击
        */
        for (MenuItem m :
                menu.list) {
            m.click();
        }
    }
}
