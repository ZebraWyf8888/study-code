package note.simplefactory.product;

/**
* @Author: WYF
* @Description: 男人
* @Create: 2020/5/17 0:30
* @Version: 1.0
*/
public class Man implements Person{
    public Man() {
        this.make();
    }
    @Override
    public void make() {
        System.out.println(this.getClass()+"我是男人被生产出来了");
    }

}
