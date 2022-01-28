package macleetcode.code1.observer;

public class SharesPerson implements Observer {
    @Override
    public void hear() {
        System.out.println("收到股票降价消息");
    }
}
