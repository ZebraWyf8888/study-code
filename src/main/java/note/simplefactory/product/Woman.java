package note.simplefactory.product;

/**
* @Author: WYF
* @Description: 女人
* @Create: 2020/5/17 0:30
* @Version: 1.0
*/
public class Woman implements Person{
    public Woman() {
        this.make();
    }
    @Override
    public void make() {
        System.out.println(this.getClass()+"我是女人被生产出来了");
    }

}
