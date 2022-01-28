package macleetcode.code1.strategy;

public class ComputerBookStrategy implements Strategy{
    @Override
    public void closing() {
        System.out.println("ComputerBookStrategy策略结账");
    }
}
