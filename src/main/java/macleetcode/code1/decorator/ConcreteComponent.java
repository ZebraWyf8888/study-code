package macleetcode.code1.decorator;

/**
* @Author: WYF
* @Description: 题目中肯定需要获取请求正文
 * 所以对请求正文的解析是基础
* @Create: 2020/4/26 14:23
* @Version: 1.0
*/
public class ConcreteComponent extends Component {
    @Override
    public void analy() {
        //do something
        System.out.println("我是最基础的功能，对请求正文的解析");
    }
}
