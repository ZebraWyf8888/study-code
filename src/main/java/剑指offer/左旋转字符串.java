package 剑指offer;

/**
 * 左旋转字符串
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 22:08
 */
public class 左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (n <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
