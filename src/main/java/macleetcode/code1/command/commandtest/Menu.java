package macleetcode.code1.command.commandtest;

import java.util.ArrayList;
import java.util.List;

/**
* @Author: WYF
* @Description: 菜单项，方法1增加菜单
* @Create: 2020/5/30 23:06
* @Version: 1.0
*/
public class Menu {
    List<MenuItem> list = new ArrayList<>();
    public void addMenuItem(MenuItem menuItem){
        list.add(menuItem);
    }
}
