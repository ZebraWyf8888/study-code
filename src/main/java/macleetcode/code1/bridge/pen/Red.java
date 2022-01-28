package macleetcode.code1.bridge.pen;

public class Red implements Color {
    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + "红色的"+ name + ".");
    }
}
