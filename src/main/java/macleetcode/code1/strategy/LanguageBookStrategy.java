package macleetcode.code1.strategy;

public class LanguageBookStrategy implements Strategy {
    @Override
    public void closing() {
        System.out.println("LanguageBookStrategy策略结账");
    }
}
