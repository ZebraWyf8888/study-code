package macleetcode.code1.strategy;

public class NovelBookStrategy implements Strategy{
    @Override
    public void closing() {
        System.out.println("NovelBookStrategy策略结账");
    }
}
