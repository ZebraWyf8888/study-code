package java8.question;

/**
 * @Author: WYF
 * @Description: 一个有n级的台阶，一次可以走1级、2级或3级，问走完n级台阶有多少种走法。
 * @Create: 2020/4/23 23:08
 * @Version: 1.0
 */
public class GoStepts {
    public static int countWays(int x) {
        int[] arr = new int[x + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= x; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i-3];
        }
        return arr[x];
    }
    public static void main(String[] args) {
        System.out.println(countWays(5)); // 13
    }
}
