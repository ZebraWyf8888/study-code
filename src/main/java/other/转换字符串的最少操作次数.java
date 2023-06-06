package other;

/**
 * 转换字符串的最少操作次数
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 01:46
 */
public class 转换字符串的最少操作次数 {
    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                res += 1;
                i += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 转换字符串的最少操作次数().minimumMoves("XXOX"));
    }
}
