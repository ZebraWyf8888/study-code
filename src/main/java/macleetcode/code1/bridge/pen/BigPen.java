package macleetcode.code1.bridge.pen;

public class BigPen extends Pen {
    @Override
    public void draw(String name) {
        String penType="大号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}
