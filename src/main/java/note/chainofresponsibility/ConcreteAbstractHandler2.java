package note.chainofresponsibility;

/**
 *@author wyf
 */
public class ConcreteAbstractHandler2 extends AbstractHandler {
    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request<20) {
            System.out.println(this.getClass()+"处理请求："+request);
        }else if (successor!=null){
            successor.handleRequest(request);
        }
    }
}
