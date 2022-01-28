package note.strategy;

public class BookSystem {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void payMoney(){
        if (strategy != null) {
            strategy.closing();
        }
    }
}
