package note.component;

/**
* @Author: WYF
* @Description: 测试类
* @Create: 2020/4/21 2:06
* @Version: 1.0
*/
public class TestComponent {
    public static void main(String[] args) {
        /**
         * @Description:文件夹1 ，有一个ImageFile()和MediaFile();
         */
        Folder composite = new Folder("文件夹1");
        Component leaf1 = new ImageFile();
        Component leaf2 = new MediaFile();
        /**
         * @Description: 加入文件夹1
        */
        composite.add(leaf1);
        composite.add(leaf2);

        /**
         * @Description:文件夹2 ，包含文件夹1和TextFile();
         */
        Folder composite2 = new Folder("文件夹2");
        Component leaf3 = new TextFile();
        /**
         * @Description: 把文件夹1加入文件夹2
         */
        composite2.add(composite);
        composite2.add(leaf3);

        /**
         * @Description:调用杀毒软件
        */
        AntiVirus.doThing(composite2);
    }
    
}
