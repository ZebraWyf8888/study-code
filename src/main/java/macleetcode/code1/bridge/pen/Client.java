package macleetcode.code1.bridge.pen;

public class Client {
    public static void main(String[] args) {
        Color color = new Black();
        Pen pen = new BigPen();
        pen.setColor(color);
        pen.draw("hua");
    }
}
