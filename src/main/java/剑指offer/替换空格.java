package 剑指offer;

/**
 * 替换空格
 *
 * @author canjiechen
 * @version 2.0.0
 * @date 2023/6/3 21:59
 */
public class 替换空格 {

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(new 替换空格().replaceSpace("We are happy."));
    }
}
