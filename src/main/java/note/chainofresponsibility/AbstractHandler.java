package note.chainofresponsibility;

/**
 *@author wyf
 */
public abstract class AbstractHandler {
    protected String name;
    protected AbstractHandler successor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractHandler getSuccessor() {
        return successor;
    }

    public void setSuccessor(AbstractHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理请求
     * @param request
     */
    public abstract void handleRequest(int request);
}
