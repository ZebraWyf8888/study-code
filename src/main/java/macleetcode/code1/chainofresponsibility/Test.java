package macleetcode.code1.chainofresponsibility;

/**
 *@author wyf
 */
public class Test {
    public static void main(String[] args) {
        ConcreteAbstractHandler1 concreteAbstractHandler1 = new ConcreteAbstractHandler1();
        ConcreteAbstractHandler2 concreteAbstractHandler2 = new ConcreteAbstractHandler2();
        ConcreteAbstractHandler3 concreteAbstractHandler3 = new ConcreteAbstractHandler3();

        concreteAbstractHandler1.setSuccessor(concreteAbstractHandler2);
        concreteAbstractHandler2.setSuccessor(concreteAbstractHandler3);

        concreteAbstractHandler1.handleRequest(-1);
    }
}
