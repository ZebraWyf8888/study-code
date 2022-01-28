package note.chainofresponsibility;

/**
 *@author wyf
 */
public class ConcreteAbstractHandler3 extends AbstractHandler {
    @Override
    public void handleRequest(int request) {
        if (request <= 0) {
            System.out.println(this.getClass()+"处理请求："+request);
        }else if (successor!=null){
            successor.handleRequest(request);
        }
    }
}
