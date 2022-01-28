package note.strategy;

public class TestStrategy {
    public static void main(String[] args) {
        BookSystem bookSystem = new BookSystem();
        bookSystem.setStrategy(new ComputerBookStrategy());
        bookSystem.payMoney();
        bookSystem.setStrategy(new NovelBookStrategy());
        bookSystem.payMoney();
        bookSystem.setStrategy(new LanguageBookStrategy());
        bookSystem.payMoney();
    }
}
