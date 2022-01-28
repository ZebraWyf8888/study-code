package macleetcode.code1.decorator.decoratortest;

/**
* @Author: WYF
* @Description: 书的基本方法
*/
public class Book extends Component {

    @Override
    public void borrowBook() {
        System.out.println("最基础的功能，借书");
    }

    @Override
    public void returnBook() {
        System.out.println("最基础的功能，还书");
    }
}
