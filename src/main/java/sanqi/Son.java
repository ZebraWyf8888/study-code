package sanqi;

public class Son extends Father {

    public Son() {
    }

    @Override
    public void display() {
        System.out.println("Son's display");
    }

    public static void main(String[] args) {
        new Son();
    }

}