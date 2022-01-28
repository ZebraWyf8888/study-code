package note.component;

import java.util.ArrayList;
import java.util.List;

/**
* @Author: WYF
* @Description: 在组合文件的文件夹，组合部件
* @Create: 2020/4/21 2:05
* @Version: 1.0
*/
public class Folder implements Component{
    private String folderName;

    private List<Component> list = new ArrayList<Component>();

    public void add(Component component) {
        list.add(component);
    }

    public void remove(Component component) {
        list.remove(component);
    }

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public List<Component> getAll() {
        return list;
    }


    @Override
    public void doSomething() {
        System.out.println("[我是文件夹"+this.folderName+"\t 对以下文件进行杀毒");
        for (Component component : list) {
            component.doSomething();
        }
        System.out.println("我是文件夹"+this.folderName+"\t 对以上文件进行杀毒完毕]");
    }
}
