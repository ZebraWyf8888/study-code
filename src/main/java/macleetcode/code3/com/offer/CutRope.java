package macleetcode.code3.com.offer;

public class CutRope {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        if (target == 4) {
            return 4;
        }
        int i = target / 3;
        int m = target % 3;
        if (m == 1) {
            return (int) (Math.pow(3, i - 1) + 4);
        } else if (m == 2) {
            return (int) Math.pow(3, i) * 2;
        } else if (m == 0) {
            return (int) Math.pow(3, i);
        }else {
            return 0;
        }
    }
}
