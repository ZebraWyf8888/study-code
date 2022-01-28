package java8.com.offer;

public class JumpFloor {
    public static int JumpFloor(int target) {
        if (target == 2) {
            return 2;
        }else if (target == 1){
            return 1;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(11));
    }
}
